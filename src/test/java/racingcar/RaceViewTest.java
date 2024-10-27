package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    RaceView raceView;
    Cars cars;

    @BeforeEach
    void setUp() {
        // 출력 스트림을 가로채기 위해 System.out 재설정
        System.setOut(new PrintStream(outContent));
        raceView = new RaceView();
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝난 후 원래 출력 스트림으로 복원
        System.setOut(originalOut);
    }


    @Test
    void displayOneTrialTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(input);
        cars.registerObserver(raceView);
        raceView.setCars(cars);
        //when
        cars.putAll(Map.of("pobi", 1, "ddot", 0));
        raceView.displayOneTrial();
        //then
        assertThat(outContent.toString()).contains("pobi : -\n" + "ddot : \n");
    }

    @Test
    void displayWinnerTest() {
        //give
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(input);
        cars.registerObserver(raceView);
        cars.putAll(Map.of("pobi", 1, "ddot", 0));
        raceView.setCars(cars);
        //when
        raceView.displayWinner();
        //thans
        assertThat(outContent.toString().trim()).contains("pobi");

    }

    @Test
    void updateGoTrialTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(input);
        cars.registerObserver(raceView);
        cars.putAll(Map.of("pobi", 1, "ddot", 0));
        //when
        raceView.updateGoTrial(cars);
        //then
        assertThat(outContent.toString()).contains("pobi : -\n" + "ddot : \n");
    }

    @Test
    void updateWinnerTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(input);
        cars.registerObserver(raceView);
        cars.putAll(Map.of("pobi", 1, "ddot", 0));
        //when
        raceView.updateWinner(cars);
        //than
        assertThat(outContent.toString()).contains("pobi");
    }

    @Test
    void canCarsGoUpdateObserverTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(input);
        cars.registerObserver(raceView);
        //when, then
        assertRandomNumberInRangeTest(
                () ->
                {
                    cars.go();
                    assertThat(outContent.toString()).contains("pobi : -\n" + "ddot : \n");
                },
                4, 3);
    }
}