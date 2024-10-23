package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void validator_ShouldReturnTrue_WhenAllNamesAreValid() {
        String[] validInput = {"car", "bike", "bus"};

        boolean result = inputValidator.validator(validInput);

        assertTrue(result);
    }

    @Test
    void validator_ShouldReturnFalse_WhenNameIsTooLong() {
        String[] invalidInput = {"benz", "volkswagen", "bmw"};

        boolean result = inputValidator.validator(invalidInput);

        assertFalse(result);
    }

    @Test
    void validator_ShouldReturnFalse_WhenNameIsEmpty() {
        String[] invalidInput = {"", "car", "bus"};

        boolean result = inputValidator.validator(invalidInput);

        assertFalse(result);
    }

}
