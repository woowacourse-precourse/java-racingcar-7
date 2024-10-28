package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void testCarCreation() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
        assertEquals(0, car.getCurrentPos());
    }

    @Test
    void testCarMove() {
        Car car = new Car("pobi");
        car.incCurrentPos();
        assertEquals(1, car.getCurrentPos());
    }

    @Test
    void testRandomNumberGeneration() {
        Car car = new Car("pobi");
        int randomNumber = car.setAndReturnRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    void testCarComparison() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        car1.incCurrentPos();
        car1.incCurrentPos();
        car2.incCurrentPos();

        assertTrue(car1.compareTo(car2) < 0);
    }
}