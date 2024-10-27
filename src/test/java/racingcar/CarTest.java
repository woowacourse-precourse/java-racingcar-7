package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("차량 전진 확인")
    void test1() {
        Car car = new Car();
        int before = car.getLocation();

        car.moveForward();

        assertThat(car.getLocation()).isEqualTo(before + 1);
    }
}
