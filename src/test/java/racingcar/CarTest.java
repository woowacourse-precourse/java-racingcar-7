package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void testCreateCar() {
        Car car = new Car("a");
        assertEquals("a", car.getName());
        assertEquals(0, car.getPosition());
    }
}
