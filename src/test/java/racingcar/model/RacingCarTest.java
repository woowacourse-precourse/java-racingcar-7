package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void testCarMovesWhenShouldMoveIsTrue() {
        RacingCar car = new RacingCar("CarA");
        car.move(true);
        assertEquals(1, car.getPosition(), "Car should move by 1 position when shouldMove is true");
    }

    @Test
    void testCarDoesNotMoveWhenShouldMoveIsFalse() {
        RacingCar car = new RacingCar("CarA");
        car.move(false);
        assertEquals(0, car.getPosition(), "Car should not move when shouldMove is false");
    }

    @Test
    void testCarNameIsTrimmed() {
        RacingCar car = new RacingCar(" CarB ");
        assertEquals("CarB", car.getName(), "Car name should be trimmed of leading and trailing spaces");
    }
}
