package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    @DisplayName("인자로 전달된 값이 4 이상이면 true, 미만이면 false를 반환한다.")
    @Test
    void 전진_판단_기능_테스트() {
        Car car = new Car("car");

        assertTrue(car.isMovable(9));
        assertTrue(car.isMovable(4));
        assertFalse(car.isMovable(0));
        assertFalse(car.isMovable(3));
    }
}
