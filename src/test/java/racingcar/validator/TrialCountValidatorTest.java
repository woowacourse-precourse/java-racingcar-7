package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarRacingException;

public class TrialCountValidatorTest {

    @Test
    void 유효하지_않은_시도_횟수_예외() {
        assertThrows(CarRacingException.class, () -> TrialCountValidator.validate(0));
        assertThrows(CarRacingException.class, () -> TrialCountValidator.validate(-1));
    }
}
