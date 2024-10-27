package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    @DisplayName("canMove() 값이 참일 경우, 차가 움직인다")
    void moveTest() {
        Car car = new Car("testcar") {
            @Override
            boolean canMove() {
                return true;
            }
        };
        car.move();
        assertEquals(car.getPosition(), 1);
    }

}
