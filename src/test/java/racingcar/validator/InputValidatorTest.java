package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.View.constant.ErrorMessage.TOO_LONG_VALUE;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 다섯글자_넘을경우_예외처리() {
        String fiveLetters = "다섯글자 예외";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.check(fiveLetters)
        );
        assertEquals(TOO_LONG_VALUE.getMessage(), exception.getMessage());
    }
}