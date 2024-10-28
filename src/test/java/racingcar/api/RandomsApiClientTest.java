package racingcar.api;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomsApiClientTest {

    @DisplayName("시작이 끝 초과, 끝이 Integer.MAX_VALUE와 동일, 범위가 Integer.MAX_VALUE 초과하면 호출을 실패합니다")
    @MethodSource("createInvalidRange")
    @ParameterizedTest
    void 랜덤_값_API_호출_실패(int start, int end, String expected) {
        assertThatThrownBy(() -> RandomsApiClient.getRandomNumber(start, end))
                .isInstanceOf(InvalidRangeException.class)
                .hasMessage(expected);
    }

    @DisplayName("시작이 끝 이하, 끝이 Integer.MAX_VALUE 이하, 범위가 Integer.MAX_VALUE 미만이면 호출을 성공합니다")
    @Test
    void 랜덤_값_API_호출_성공() {
        assertDoesNotThrow(() -> RandomsApiClient.getRandomNumber(0, Integer.MAX_VALUE - 1));
    }

    static Stream<Arguments> createInvalidRange() {
        return Stream.of(
                Arguments.of(10, 9, "startInclusive cannot be greater than endInclusive."),
                Arguments.of(1, Integer.MAX_VALUE, "endInclusive cannot be greater than Integer.MAX_VALUE."),
                Arguments.of(-1, Integer.MAX_VALUE - 1, "the input range is too large.")
        );
    }

}
