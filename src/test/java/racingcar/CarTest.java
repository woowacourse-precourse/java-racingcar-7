package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {

    @Test
    void testCarInitialization() {
        Car car = new Car("sun");
        assertEquals("sun", car.getName());
        assertEquals(0, car.getDistance());
    }

    @Test
    void testCarMoveForward() {
        Car car = new Car("sun");
        for (int i = 0; i < 5; i++) {
            car.moveForward();
        }
        assertEquals(5, car.getDistance());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
