package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceManagerTest {
    private RaceManager raceManager;

    @BeforeEach
    void setUp() {
        raceManager = new RaceManager();
    }

    @Test
    void findOneWinnerTest() throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car1 = new Car("CarA");
        Car car2 = new Car("CarB");
        Car car3 = new Car("CarC");
        for (int i = 0; i < 3; i++) {
            car1.incCurrentPos();
        }
        car2.incCurrentPos();
        car3.incCurrentPos();
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // private field인 cars에 임시 접근하기 위해
        Field privateField = RaceManager.class.getDeclaredField("cars");
        privateField.setAccessible(true);

        privateField.set(raceManager, cars);

        // when
        List<String> actualResult = raceManager.findWinner();

        // then
        List<String> expectedResult = List.of("CarA");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void findMultiWinnersTest() throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car1 = new Car("CarA");
        Car car2 = new Car("CarB");
        Car car3 = new Car("CarC");
        for (int i = 0; i < 3; i++) {
            car1.incCurrentPos();
            car3.incCurrentPos();
        }
        car2.incCurrentPos();
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // private field인 cars에 임시 접근하기 위해
        Field privateField = RaceManager.class.getDeclaredField("cars");
        privateField.setAccessible(true);

        privateField.set(raceManager, cars);

        // when
        List<String> actualResult = raceManager.findWinner();

        // then
        List<String> expectedResult = new ArrayList<>(Arrays.asList("CarA", "CarC"));
        assertEquals(expectedResult, actualResult);
    }
}
