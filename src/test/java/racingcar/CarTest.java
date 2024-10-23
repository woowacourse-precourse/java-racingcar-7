package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void test1() {
        Assertions.assertThatThrownBy(() ->
                        new Car("다섯글자가넘는차"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
