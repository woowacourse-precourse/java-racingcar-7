package racingcar.domain.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarValidatorTest {

    private CarValidator carValidator = new CarValidator();

    @Test
    @DisplayName("입력 범위를 초과하여 이름을 입력할 경우 예외다")
    void throw_when_name_length_is_over_range() {
        String names = "franki";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carValidator.validateMaximumLength(names.strip());
        });
    }
}
