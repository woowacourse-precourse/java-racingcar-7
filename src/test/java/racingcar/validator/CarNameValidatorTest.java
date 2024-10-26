package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {


    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값이 빈문자열이라면 예외가 발생한다.")
    void testCarNameIsEmpty() {
        //given
        String emptyInput = "";

        //when & then
        assertThrows(IllegalArgumentException.class,()->{
            inputValidator.validateIsEmpty(emptyInput);
        });
    }

}
