package racingcar;

import java.lang.reflect.Field;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    Logger log = Logger.getLogger(CarTest.class.getName());

    @Test
    void carDefaultValuesTest() {
        Car car = new Car("mini", 9);
        Assertions.assertEquals("mini", car.getName());
        Assertions.assertEquals(0, car.getProgress());
        log.info(car.getCount() + "");
        Assertions.assertTrue(car.getCount() >= 4);
    }

    @Test
    void randomMoveTest() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("mini", 9);
        Field progressField = car.getClass().getDeclaredField("progress");
        progressField.setAccessible(true);
        progressField.set(car, car.getCount());

        Assertions.assertTrue(car.randomMove(0));
        Assertions.assertFalse(car.randomMove(2));
    }
}
