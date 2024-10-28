package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void carNameLengthTest() {
        Car car = new Car("ABCDE");
        assertEquals("ABCDE", car.getCarName());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("ABCDEF");
        });
        assertTrue(exception.getMessage().contains("차의 이름이 5글자를 넘어갑니다."));
    }

    @Test
    void carMovementTest() {
        Car car = new Car("pobi");
        int initialDistance = car.getDistance();

        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 10; j++) {
                car.goStraight(0, 9, 4);
            }
            assertTrue(car.getDistance() >= initialDistance);
        }
    }
}
