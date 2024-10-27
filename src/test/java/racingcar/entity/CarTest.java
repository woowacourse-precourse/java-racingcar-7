package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.GameConstant.MOVEMENT_THRESHOLD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @Test
    void 자동차_전진_성공() {
        car.moveCar(MOVEMENT_THRESHOLD);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getPositionString()).isEqualTo("car : -");
    }

    @Test
    void 자동차_전진_실패() {
        car.moveCar(MOVEMENT_THRESHOLD - 1);
        assertThat(car.getPosition()).isZero();
        assertThat(car.getPositionString()).isEqualTo("car : ");
    }
}