package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 이동() {
        Car car = new Car("car1");

        car.move();
        car.move();

        assertThat(car.getMovement()).isEqualTo(2);
    }
}