package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarCreationWithValidName() {
        Car car = new Car("Racer");
        assertEquals("Racer", car.getName());
    }

    @Test
    public void testCarCreationWithInvalidNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("RacingCar");
        });
        assertEquals("자동차의 이름은 5글자를 넘을 수 없습니다.", exception.getMessage());
    }

    @Test
    public void testCarCreationWithInvalidNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
        assertEquals("자동차의 이름을 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    public void testMoveIncreasesPosition() {
        Car car = new Car("Racer");
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    public void testSetTryNumber() {
        Car car = new Car("Racer");
        car.setTryNumber(5);
        assertEquals(5, car.getTryNumber());
    }
}
