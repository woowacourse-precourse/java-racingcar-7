package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차가 전진할 때 위치가 증가한다")
    void moveForward() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.tryMove();
        assertThat(car.getPosition()).isGreaterThan(initialPosition);

    }
}
