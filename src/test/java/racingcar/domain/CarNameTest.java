package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @DisplayName("자동차 이름은 5자이하여야한다.")
    @Test
    void carNameSmallerOrEqualThan5() throws Exception{
        //given
        String name = "123456";

        //when & then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야합니다.");
    }

    @DisplayName("자동차 이름은 공백일 수 없다.")
    @Test
    void carNameCantBlank() throws Exception{
        //given
        String name = " ";
        //when & the
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이면 안됩니다.");

     }

}