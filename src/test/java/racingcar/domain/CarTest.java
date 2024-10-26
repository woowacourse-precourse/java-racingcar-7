package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_이동() {
        Car car = new Car("pobi");

        car.move();
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
