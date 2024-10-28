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

    @Test
    void testMove() {
        Car car = new Car("a");
        car.move();
        assertEquals(1, car.getPosition());
        car.move();
        assertEquals(2, car.getPosition());
    }
}
