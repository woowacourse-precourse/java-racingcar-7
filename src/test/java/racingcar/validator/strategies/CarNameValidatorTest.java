package racingcar.validator.strategies;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class CarNameValidatorTest {

    private final CarNameValidator validator = new CarNameValidator();

    @Test
    void validate_WhenCarNameExceedsFiveCharacters_ShouldThrowException() {
        // 주어진 자동차 이름이 5자를 초과할 경우
        String carNames = "Ferrari";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.NAME_TOO_LONG.getMessage());
    }

    @Test
    void validate_WhenCarNameIsEmpty_ShouldThrowException() {
        // 주어진 자동차 이름이 비어 있을 경우
        String carNames = " , , , "; // 공백으로만 이루어진 이름

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    void validate_WhenCarNamesAreDuplicate_ShouldThrowException() {
        // 주어진 자동차 이름이 중복될 경우
        String carNames = "pobi, woni, pobi";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.DUPLICATE_NAME.getMessage());
    }

    @Test
    void validate_WhenOnlyOneCarNameIsProvided_ShouldThrowException() {
        // 주어진 자동차 이름이 1대 이하일 경우
        String carNames = "pobi";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.MINIMUM_CARS.getMessage());
    }

    @Test
    void validate_WhenCarNamesAreValid_ShouldNotThrowException() {
        // 유효한 자동차 이름의 경우 예외가 발생하지 않아야 함
        String carNames = "pobi, woni";

        // 예외가 발생하지 않아야 함
        validator.validate(carNames);
    }

}
