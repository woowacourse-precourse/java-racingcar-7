package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    RacingCar racingCar;
    @BeforeEach
    void setUp() {
        this.racingCar = new RacingCar("car1");
    }

    @Test
    @DisplayName("Initial Car Name should be car1")
    void testGetName() {
        assertEquals("car1",racingCar.getName());
    }

    @Test
    @DisplayName("Initial Score should be 0")
    void testInitialScore() {
        assertEquals(new Score().getValue(), racingCar.getScore().getValue());
    }

    @Test
    @DisplayName("After car move, score should be increased")
    void testIncreaseScore() {
        racingCar.increaseScore();
        assertEquals(1, racingCar.getScore().getValue());
    }

    @Test
    @DisplayName("Move car forward if the value is equal or greater than 4")
    void testCarMovingForward() {
        racingCar.move(9);
        assertEquals(1, racingCar.getScore().getValue());
    }
    @Test
    @DisplayName("Car stay if the value is less than 4")
    void testCarStaying() {
        racingCar.move(2);
        assertEquals(0, racingCar.getScore().getValue());
    }

    @Test
    @DisplayName("Initial Car String should be \"car1 : \"")
    void testInitialCarString() {
        assertEquals("car1 : ",racingCar.toString());
    }

    @Test
    @DisplayName("Car String after moving forward should be \"car1 : -\"")
    void testMovedCarString() {
        racingCar.move(9);
        assertEquals("car1 : -",racingCar.toString());
    }
}