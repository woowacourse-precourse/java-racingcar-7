package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        String carName = "testCar";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 자동차_검증_테스트() {
        String carName = "test";
        assertThatThrownBy(() -> {
            new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = new Car("testCar1");
        Car expect = new Car("testCar2", 1L);
        final int SAME = 0;

        // when
        car.forward();

        // then
        assertThat(car.compareTo(expect)).isEqualTo(SAME);
    }

}