package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.global.ErrorMessage;

class RoundsTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 입력 값에 대해 IllegalArgumentException을 던진다")
    @MethodSource("provideInvalidInputs")
    void throwsIfInvalidInput(String invalidInput) {
        assertThatThrownBy(() -> Rounds.of(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_FORMAT_REQUIRED.getMessage());
    }

    private static Stream<Arguments> provideInvalidInputs() {
        return Stream.of(
                Arguments.of((String) null),              // null 입력
                Arguments.of(""),             // 빈 문자열
                Arguments.of("  "),           // 공백 문자열
                Arguments.of("abc")           // 숫자가 아닌 문자열
        );
    }

    @ParameterizedTest
    @CsvSource({"5, 5", "0, 0"})
    @DisplayName("Rounds는 유효한 입력 값을 받아 올바르게 생성된다.")
    void construct(String input, int expectedValue) {
        Rounds rounds = Rounds.of(input);
        Assertions.assertThat(rounds.value()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("음수 값을 직접 입력할 경우 IllegalArgumentException을 던진다")
    void throwsIfNegativeValue() {
        assertThatThrownBy(() -> new Rounds(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.POSITIVE_INTEGER_ALLOWED.getMessage());
    }
}
