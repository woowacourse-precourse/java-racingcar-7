package racingcar.validator.strategies.trycount;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class PositiveIntegerValidatorTest {

    private final PositiveIntegerValidator validator = new PositiveIntegerValidator();


    @Test
    void validate_WhenValueIsNotANumber_ShouldThrowException() {
        String value = "invalid";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(value))
                .withMessageContaining(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenValueIsNegative_ShouldThrowException() {
        String value = "-1";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(value))
                .withMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenValueIsZero_ShouldThrowException() {
        String value = "0";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(value))
                .withMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void validate_WhenValueIsValid_ShouldNotThrowException() {
        String value = "5"; // 유효한 시도 횟수
        validator.validate(value); // 예외가 발생하지 않아야 함
    }

}
