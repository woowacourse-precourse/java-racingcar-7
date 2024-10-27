package racingcar.validator.strategies.trycount;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import racingcar.constants.RacingGameConstants;
import racingcar.view.ErrorMessage;

public class TryCountMaximumValidatorTest {

    private final TryCountMaximumValidator validator = new TryCountMaximumValidator();

    @Test
    void validate_WhenTryCountIsWithinMax_ShouldNotThrowException() {
        // 최대 허용 시도 횟수 이하인 경우 예외가 발생하지 않아야 함
        String validTryCount = String.valueOf(RacingGameConstants.MAX_TRY_COUNT.getValue());
        assertThatNoException().isThrownBy(() -> validator.validate(validTryCount));
    }

    @Test
    void validate_WhenTryCountExceedsMax_ShouldThrowException() {
        // 최대 허용 시도 횟수를 초과하는 경우 예외가 발생해야 함
        String invalidTryCount = String.valueOf(RacingGameConstants.MAX_TRY_COUNT.getValue() + 1);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(invalidTryCount))
                .withMessage(ErrorMessage.EXCEEDS_MAX_TRY_COUNT.getMessage());
    }


}
