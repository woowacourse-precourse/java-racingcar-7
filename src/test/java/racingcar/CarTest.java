package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

    @Test
    void test1() {
        Assertions.assertThatThrownBy(() -> new Car("다섯글자가넘는차"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void test2(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test3() {
        Car car1 = new Car("car1");

        int distance1 = car1.go();
        int distance2 = car1.go();
        int distance3 = car1.go();

        Assertions.assertThat(distance1).isEqualTo(1);
        Assertions.assertThat(distance2).isEqualTo(2);
        Assertions.assertThat(distance3).isEqualTo(3);
    }
}
