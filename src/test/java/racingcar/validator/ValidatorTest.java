package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 자동차_이름_5자_이상(){
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName("TooLongName");
        });
    }

    @Test
    void 자동차_이름_5자_이하(){
        assertDoesNotThrow(() -> Validator.validateCarName("CarA"));
        assertDoesNotThrow(() -> Validator.validateCarName("CarB"));
    }

    @Test
    void 시도횟수_숫자_아님(){
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateTryNumber("CarA");
        });
    }

    @Test
    void 시도횟수_숫자(){
        assertDoesNotThrow(() -> Validator.validateTryNumber("10"));
    }
}
