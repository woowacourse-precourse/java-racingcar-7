package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.message.ExceptionMessage.*;

public class InputValidatorTest {

    @DisplayName("빈 문자열만 자동차 이름으로 입력할 시 예외가 발생한다")
    @Test
    void emptyCarNameInput(){
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateNameInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_INPUT.getMessage());
    }

    @DisplayName("양수가 아닌 값을 시도횟수로 입력하면 예외가 발생한다")
    @Test
    void negativeAttemptNumberInput(){
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateNumberInput(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_ATTEMPT_INPUT.getMessage());
    }

    @DisplayName("0을 시도횟수로 입력하면 예외가 발생한다")
    @Test
    void zeroAttemptNumberInput(){
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateNumberInput(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_ATTEMPT_INPUT.getMessage());
    }

}
