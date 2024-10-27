package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 값을 입력할 경우 예외가 발생한다")
    void throw_when_input_is_not_numeric() {
        String input = "장보고";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumeric(input);
        });
    }

    @Test
    @DisplayName("숫자를 입력하면 정상적으로 작동한다")
    void run_when_input_is_numeric() {
        String input = "8";

        Assertions.assertDoesNotThrow(() -> InputValidator.validateNumeric(input));
    }
}
