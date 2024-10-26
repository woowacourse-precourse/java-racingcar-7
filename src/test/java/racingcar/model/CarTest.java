package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        String carName = "test";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 자동차_검증_테스트() {
        String carName1 = "test10";
        String carName2 = "";

        assertThatThrownBy(() -> {
            new Car(carName1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Car(carName2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_비교_테스트() {
        // given
        Car car1 = new Car("test1", 100L);
        Car car2 = new Car("test2", 100L);
        Car car3 = new Car("test3", 101L);
        Car car4 = new Car("test4", 99L);

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
        Car car = new Car("test1");
        Car expect = new Car("test2", 1L);

        // when
        car.forward();

        // then
        assertThat(car.compareTo(expect)).isEqualTo(0);
    }

}