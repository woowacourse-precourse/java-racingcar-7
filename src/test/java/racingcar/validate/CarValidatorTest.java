package racingcar.validate;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidatorTest {
    private CarValidator carValidator;

    @BeforeEach
    void setUp() {
        carValidator = new CarValidator();
    }

    @DisplayName("차 이름은 5자 이하여야 합니다.")
    @Test
    void carNameLengthLimit5() {
        String carName = "pobiii";

        assertThrows(IllegalArgumentException.class, () -> carValidator.carNameLengthLimit5(carName));
    }

    @DisplayName("차 이름은 중복되서는 안됩니다.")
    @Test
    void noDuplicateCarNames() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "woni", "jun");

        assertThrows(IllegalArgumentException.class, () -> carValidator.noDuplicateCarNames(carNames));
    }

}
