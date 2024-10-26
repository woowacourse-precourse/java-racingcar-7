package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    void car_name_length() {
        String carNames = "ABCDFG,12345";
        Assertions.assertThatThrownBy(() -> CarNameValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_name_duplication() {
        String carNames = "test,a,b,c,test";
        Assertions.assertThatThrownBy(() -> CarNameValidator.validateCarNameDuplication(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}