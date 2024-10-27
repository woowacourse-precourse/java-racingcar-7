package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    void validateNullInput() {
        assertThatThrownBy(() -> validator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
    void validateEmptyInput() {
        assertThatThrownBy(() -> validator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 빈 값이 있으면 예외가 발생한다")
    void validateEmptyCarName() {
        assertThatThrownBy(() -> validator.validateCarNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값이거나 공백을 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있으면 예외가 발생한다")
    void validateCarNameWithSpace() {
        assertThatThrownBy(() -> validator.validateCarNames("pobi,wo ni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값이거나 공백을 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void validateCarNameLength() {
        assertThatThrownBy(() -> validator.validateCarNames("pobi,woni,jupiter"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도 횟수가 0 이하이면 예외가 발생한다")
    void validateNonPositiveAttempts(String input) {
        assertThatThrownBy(() -> validator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0보다 커야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", " "})
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    void validateNonNumericAttempts(String input) {
        assertThatThrownBy(() -> validator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }
}
