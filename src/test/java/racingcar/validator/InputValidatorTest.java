package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {

    @Test
    @DisplayName("숫자를 입력할 경우 정상적으로 동작한다.")
    void validateNumber() {
        // given
        String input = "1";

        // when, then
        assertDoesNotThrow(() -> InputValidator.validateNumber(input));

    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 입력될 경우 예외가 발생한다.")
    void validateNumberThrowsException() {
        // given
        String input = "a";
        // when, then
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}