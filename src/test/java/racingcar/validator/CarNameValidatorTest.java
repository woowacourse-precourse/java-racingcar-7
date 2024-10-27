package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.validator.CarNameValidator.DUPLICATE_CAR_NAME_MESSAGE;
import static racingcar.validator.CarNameValidator.EMPTY_NAME_MESSAGE;
import static racingcar.validator.CarNameValidator.INVALID_NAME_FORMAT_MESSAGE;
import static racingcar.validator.CarNameValidator.LENGTH_EXCEED_MESSAGE;

import org.junit.jupiter.api.Test;

class CarNameValidatorTest {
    @Test
    void 허용된_이름_길이_검증() {
        String[] exceedNameLengthCar = {"exceedCar"};

        assertThatThrownBy(() -> CarNameValidator.validateCarName(exceedNameLengthCar))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(LENGTH_EXCEED_MESSAGE);
    }


    @Test
    void 자동차_이름_공백_검증() {
        String[] emptyCarName = {""};

        assertThatThrownBy(() -> CarNameValidator.validateCarName(emptyCarName))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }

    @Test
    void 자동차_이름_중복_검증() {
        String[] duplicateCarName = {"car", "car"};

        assertThatThrownBy(() -> CarNameValidator.validateCarName(duplicateCarName))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME_MESSAGE);
    }

    @Test
    void 공백으로만_입력된_자동차_이름_검증() {
        String[] whiteSpaceCarName = {"  "};

        assertThatThrownBy(() -> CarNameValidator.validateCarName((whiteSpaceCarName)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME_MESSAGE);
    }

    @Test
    void 공백으로_시작하거나_끝나는_이름_검증() {
        String[] invalidCarNameFormat = {" car "};

        assertThatThrownBy(() -> CarNameValidator.validateCarName((invalidCarNameFormat)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_FORMAT_MESSAGE);
    }
}