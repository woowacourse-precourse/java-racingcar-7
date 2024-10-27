package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptValidatorTest {

    @Test
    @DisplayName("유효한 시도 횟수 입력 처리")
    void validateValidAttempt() {
        String input = "5";
        int attempt = AttemptValidator.validateAttempt(input);
        assertThat(attempt).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "오", " "})
    @DisplayName("숫자가 아닌 입력에 대한 예외 발생")
    void validateNonNumericInput(String input) {
        assertThatThrownBy(() -> AttemptValidator.validateAttempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    @DisplayName("1 미만의 숫자 입력에 대한 예외 발생")
    void validateNegativeAttempt(String input) {
        assertThatThrownBy(() -> AttemptValidator.validateAttempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}