package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidatorTest {
    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }

    @DisplayName("이름이 5자 이상이면 예외가 발생 한다.")
    @Test
    void checkNameLength() {
        // Arrange
        String name = "stephanie";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.isLengthUnderFive(name);
        });
    }

    @DisplayName("이름은 빈 문자열이면 안 된다.")
    @Test
    void checkNameNotEmpty() {
        //Arrange
        String name = "";

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.isNotEmpty(name);
        });
    }
}
