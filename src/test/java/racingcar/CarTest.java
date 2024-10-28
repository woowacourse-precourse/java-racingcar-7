package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;

class CarTest {
    private Car testCar;

    void setUp() {
        testCar = new Car("tube");
    }

    @RepeatedTest(100)
    void move() {
        setUp();
        int initialPosition = testCar.getPosition();
        testCar.move();
        int newPosition = testCar.getPosition();
        assertTrue(newPosition == initialPosition || newPosition == initialPosition + 1);
    }

    @Test
    void getPositionString() {
        setUp();
        testCar.move();
        testCar.move();
        testCar.move();
        testCar.move();

        String positionString = testCar.getPositionString();

        assertTrue(positionString.matches("-{0,4}"));
        assertEquals(testCar.getPosition(), positionString.length());
    }

}