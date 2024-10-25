package racingcar.validator.strategies.trycount;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class NotNullOrEmptyTryCountValidatorTest {

    private final NotNullOrEmptyTryCountValidator validator = new NotNullOrEmptyTryCountValidator();

    @Test
    void validate_WhenValueIsNull_ShouldThrowException() {
        String value = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(value))
                .withMessage(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenValueIsEmpty_ShouldThrowException() {
        String value = "  ";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(value))
                .withMessage(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenValueIsValid_ShouldNotThrowException() {
        String value = "5"; // 유효한 시도 횟수
        validator.validate(value); // 예외가 발생하지 않아야 함
    }

}
