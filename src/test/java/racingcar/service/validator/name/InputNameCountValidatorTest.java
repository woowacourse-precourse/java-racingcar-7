package racingcar.service.validator.name;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNameCountValidatorTest {
    private String invalidCountNames;
    private InputNameCountValidator inputNameCountValidator;

    @BeforeEach
    void setUp() {
        StringBuilder inputNames = new StringBuilder("1");
        for (int i = 2; i <= 100; i++) {
            inputNames.append(",").append(i);
        }
        invalidCountNames = inputNames.toString();
        inputNameCountValidator = new InputNameCountValidator();
    }

    @Test
    @DisplayName("100개 이상의 이름이 있을 시 IllegalArgumentException 던짐")
    void shouldThrowIllegalArgumentExceptionWhenInputNameCountIsMoreThan100() {
        System.out.println(invalidCountNames);
        // when & then
        assertThrows(IllegalArgumentException.class, () -> inputNameCountValidator.validate(invalidCountNames));
    }
}