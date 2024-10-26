package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.message.ExceptionMessage.*;

public class CarNameValidatorTest {

    @DisplayName("차 이름이 5글자 이상이면 예외가 발생한다.")
    @Test
    void carNameLengthTest(){
        String carName = "bbobbi";
        assertThatThrownBy(() -> CarNameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_OVER_FIVE_LENGTH.getMessage());
    }

    @DisplayName("차 이름이 공백이면 예외가 발생한다")
    @Test
    void carNameEmptyTest(){
        String carName = " ";
        assertThatThrownBy(() -> CarNameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_NOT_BLANK.getMessage());
    }

}
