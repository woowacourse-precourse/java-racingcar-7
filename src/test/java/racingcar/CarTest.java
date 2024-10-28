package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Logger log = Logger.getLogger(CarTest.class.getName());
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("mini", 9);
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterSetUp() {
        System.setOut(standardOut);
    }

    @Test
    void carDefaultValuesTest() {
        Assertions.assertEquals("mini", car.getName());
        Assertions.assertEquals(0, car.getProgress());
        log.info(car.getCount() + "");
        Assertions.assertTrue(car.getCount() >= 4);
    }

    @Test
    void randomMoveTest() throws NoSuchFieldException, IllegalAccessException {
        Field progressField = car.getClass().getDeclaredField("progress");
        progressField.setAccessible(true);
        progressField.set(car, car.getCount());

        Assertions.assertTrue(car.randomMove(0));
        Assertions.assertFalse(car.randomMove(2));
    }

    @Test
    void showCurrentMoveTest() {
        car.showCurrentMove(false);

        Assertions.assertEquals(0, car.getProgress());

        car.showCurrentMove(true);

        Assertions.assertNotEquals(0, car.getProgress());
    }

    @Test
    void printProgressTest() throws NoSuchFieldException, IllegalAccessException {
        Field progress = Car.class.getDeclaredField("progress");
        progress.setAccessible(true);
        progress.set(car, 1);
        car.printProgress();

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("-"));
    }
}
