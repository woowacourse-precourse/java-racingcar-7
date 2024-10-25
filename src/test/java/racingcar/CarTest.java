package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_이름_문자인지_확인(){
        assertThatThrownBy(() -> Car.isCarNameString("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_이하로_제한(){
        assertThatThrownBy(() -> Car.isCarNameLengthFive("haeseon"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
