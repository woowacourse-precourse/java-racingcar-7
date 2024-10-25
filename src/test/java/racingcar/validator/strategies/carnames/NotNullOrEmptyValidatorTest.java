package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class NotNullOrEmptyValidatorTest {

    private final NotNullOrEmptyValidator validator = new NotNullOrEmptyValidator();

    @Test
    void validate_WhenCarNamesIsNull_ShouldThrowException() {
        String carNames = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    void validate_WhenCarNamesEmpty_ShouldThrowException() {
        String carNames = "  ";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    void validate_WhenCarNamesValid_ShouldNotThrowException() {
        String carNames = "pobi,woni";
        validator.validate(carNames); // 예외가 발생하지 않아야 함
    }

}
