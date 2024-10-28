package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private CarName validCarName;

    @BeforeEach
    void setUp() {
        validCarName = new CarName("A".repeat(CarName.MAX_NAME_LENGTH));
    }

    @Test
    @DisplayName("랜덤 값이 이동 기준 이상이면 이동한다")
    void 이동_테스트() {
        Car car = new Car(validCarName);
        int initialPosition = car.getPosition();

        car.moveIfRandomExceedsThreshold(Car.MOVE_THRESHOLD);
        assertEquals(initialPosition + 1, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 이동 기준 미만이면 이동하지 않는다")
    void 이동_X_테스트() {
        Car car = new Car(validCarName);
        int initialPosition = car.getPosition();

        car.moveIfRandomExceedsThreshold(Car.MOVE_THRESHOLD - 1);
        assertEquals(initialPosition, car.getPosition());
    }

}