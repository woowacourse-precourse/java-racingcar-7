package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 랜덤_숫자가_4_이상인_경우_자동차_전진() {
        // given
        Car car = new Car("TestCar");

        // when
        car.moveIfPossible(4);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자가_4_이하인_경우_자동차_멈춤() {
        // given
        Car car = new Car("TestCar");

        // when
        moveIfPossible(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
