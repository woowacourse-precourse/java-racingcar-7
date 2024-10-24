package racingcar.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 전진시_출력() {
        Car car = new Car("pobi");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getPositionDisplay()).isEqualTo("-");
    }
}
