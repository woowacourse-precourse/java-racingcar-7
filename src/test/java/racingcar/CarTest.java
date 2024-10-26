package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final Car car = new Car("testCar");

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testCarIncreaseDistance() {
        car.increaseDistance();
        assertEquals("-", car.getDistance());

        car.increaseDistance();
        assertEquals("--", car.getDistance());

        car.increaseDistance();
        car.increaseDistance();
        assertEquals("-----", car.getDistance());
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testCarMove() {
        car.move(true);
        assertEquals("-", car.getDistance());

        car.move(false);
        assertEquals("-", car.getDistance());

        car.move(true);
        car.move(true);
        car.move(true);
        car.move(true);
        assertEquals("-----", car.getDistance());
    }
}
