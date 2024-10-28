package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar("TestCar");
    }

    @Test
    public void testConstructor() {
        assertEquals("TestCar", racingCar.getCarName());
        assertEquals(1, racingCar.getCarPosition());
    }

    @Test
    public void testMoveCarPosition() {
        racingCar.moveCarPosition();
        assertEquals(2, racingCar.getCarPosition());
    }

    @Test
    public void testGetCarPosition() {
        assertEquals(1, racingCar.getCarPosition());
        racingCar.moveCarPosition();
        assertEquals(2, racingCar.getCarPosition());
    }

    @Test
    public void testGetCarName() {
        assertEquals("TestCar", racingCar.getCarName());
    }
}
