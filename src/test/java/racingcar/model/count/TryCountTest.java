package racingcar.model.count;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.ErrorMessage;

class TryCountTest {

    @Test
    @DisplayName("유효한 시도 횟수 입력")
    void validTryCount() {
        String input = "5";
        TryCount tryCount = new TryCount(input);

        assertEquals(5, tryCount.getTryCount());
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 예외 테스트")
    @ValueSource(strings = {"0", "abc", "-2"})
    void invalidTryCount(String input) {
        assertThrows(IllegalArgumentException.class, () -> new TryCount(input));
    }

    @ParameterizedTest
    @DisplayName("int 범위 초과시 예외 테스트")
    @ValueSource(strings = {"2147483648", "-2147483649"})
    void outOfRangeTryCount(String input) {
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }
}