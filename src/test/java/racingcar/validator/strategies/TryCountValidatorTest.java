package racingcar.validator.strategies;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class TryCountValidatorTest {

    private final TryCountValidator validator = new TryCountValidator();

    @Test
    void validate_WhenTryCountIsNegative_ShouldThrowException() {
        // 시도 횟수가 음수인 경우
        String tryCount = "-3";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(tryCount))
                .withMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenTryCountIsNotANumber_ShouldThrowException() {
        // 시도 횟수가 숫자가 아닌 경우
        String tryCount = "abc";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(tryCount))
                .withMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenTryCountIsEmpty_ShouldThrowException() {
        // 시도 횟수가 비어 있는 경우
        String tryCount = ""; // 빈 문자열

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(tryCount))
                .withMessage(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenTryCountIsPositive_ShouldNotThrowException() {
        // 유효한 시도 횟수인 경우 예외가 발생하지 않아야 함
        String tryCount = "5";

        // 예외가 발생하지 않아야 함
        validator.validate(tryCount);
    }

    @Test
    void validate_WhenTryCountIsZero_ShouldThrowException() {
        // 시도 횟수가 0인 경우
        String tryCount = "0";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(tryCount))
                .withMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

}
