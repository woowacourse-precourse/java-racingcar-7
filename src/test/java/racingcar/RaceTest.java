package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private final PrintStream standardOut = System.out;
    private List<Car> carList;
    private Race race;
    private int attemptCount = 5;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();

        race = new Race();

        carList.add(new Car("one", attemptCount));
        carList.add(new Car("two", attemptCount));
        carList.add(new Car("three", attemptCount));
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterSetUp() {
        System.setOut(standardOut);
    }

    @Test
    void racingTest() {
        race.racing(carList, attemptCount);
        int progress = carList.get(0).getProgress();

        Assertions.assertNotEquals(0, progress);
    }

    @Test
    void findWinnerTest() throws NoSuchFieldException, IllegalAccessException {
        race.racing(carList, attemptCount);

        race.findWinner(carList);

        Field winnerListField = race.getClass().getDeclaredField("winnerList");
        winnerListField.setAccessible(true);
        List<Car> winnerList = (List<Car>) winnerListField.get(race);

        Assertions.assertNotEquals(0, winnerList.size());
    }

    @Test
    void showWinnerTest() {
        race.racing(carList, attemptCount);
        race.findWinner(carList);
        race.showWinnerList();

        Assertions.assertTrue(outputStream.toString().contains("최종 우승자"));
    }

    @Test
    void startTest() throws NoSuchFieldException, IllegalAccessException {
        race.start(carList, attemptCount);

        Field winnerListField = race.getClass().getDeclaredField("winnerList");
        winnerListField.setAccessible(true);
        List<Car> winnerList = (List<Car>) winnerListField.get(race);

        Assertions.assertNotEquals(0, winnerList.size());
        Assertions.assertTrue(outputStream.toString().contains("최종 우승자"));
    }
}
