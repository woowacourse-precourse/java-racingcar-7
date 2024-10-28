package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.message.Error;

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

    @Test
    @DisplayName("공백 혹은 빈 문자열을 입력할 경우 해당 예외 문구를 출력한다")
    void throw_when_input_is_blank() {
        String input = "   ";

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("양수 이외의 값을 입력할 경우 해당 예외 문구를 출력한다")
    void throw_when_input_is_not_positive() {
        int input = -1;

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> InputValidator.validatePositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.NOT_POSITIVE.getMessage());
    }
}
