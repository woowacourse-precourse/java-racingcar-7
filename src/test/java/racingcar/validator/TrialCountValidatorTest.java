package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

public class TrialCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생")
    void nonNumericInput() {
        CarRacingException exception = assertThrows(CarRacingException.class, () -> TrialCountValidator.validate("abc"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());

        exception = assertThrows(CarRacingException.class, () -> TrialCountValidator.validate("12abc"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 1보다 작은 경우 예외 발생")
    void lessThanOne() {
        CarRacingException exception = assertThrows(CarRacingException.class, () -> TrialCountValidator.validate("0"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_TRIAL_COUNT.getMessage());

        exception = assertThrows(CarRacingException.class, () -> TrialCountValidator.validate("-5"));
        assert exception.getMessage().equals(ErrorMessage.INVALID_TRIAL_COUNT.getMessage());
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력 시 예외가 발생하지 않음")
    void validTrialCount() {
        TrialCountValidator.validate("1");
        TrialCountValidator.validate("10");
        TrialCountValidator.validate("100");
    }
}
