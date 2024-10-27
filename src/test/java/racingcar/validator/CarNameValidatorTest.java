package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarRacingException;

public class CarNameValidatorTest {

    @Test
    void 유효하지_않은_자동차_이름_예외() {
        assertThrows(CarRacingException.class, () -> CarNameValidator.validate(""));
        assertThrows(CarRacingException.class, () -> CarNameValidator.validate(null));
        assertThrows(CarRacingException.class, () -> CarNameValidator.validate("abcdef"));
    }
}
