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
    void 자동차_비교_테스트() {
        // given
        Car car1 = new Car("testCar1", 100L);
        Car car2 = new Car("testCar2", 100L);
        Car car3 = new Car("testCar3", 101L);
        Car car4 = new Car("testCar4", 99L);

        // when
        int result1 = car1.compareTo(car2);
        int result2 = car1.compareTo(car3);
        int result3 = car1.compareTo(car4);

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(-1);
        assertThat(result3).isEqualTo(1);

    }

    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = new Car("testCar1");
        Car expect = new Car("testCar2", 1L);

        // when
        car.forward();

        // then
        assertThat(car.compareTo(expect)).isEqualTo(0);
    }

}