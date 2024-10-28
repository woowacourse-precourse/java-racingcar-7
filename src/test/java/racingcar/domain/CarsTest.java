package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static int RANDOM_NUMBER_FORWARD = 4;
    private static int RANDOM_NUMBER_STOP = 0;

    @Test
    void 객체_생성() {
        String testName0 = "car0";
        String testName1 = "car1";
        String testName2 = "car2";

        Cars cars = CarsFactory.createCars(
                String.format("%s,%s,%s", testName0, testName1, testName2)
        );

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo(testName0);
        assertThat(cars.getCars().get(1).getName()).isEqualTo(testName1);
        assertThat(cars.getCars().get(2).getName()).isEqualTo(testName2);
    }

    @Test
    void 차_1번_이동() {
        String testName0 = "pobi";
        String testName1 = "holy";
        Cars cars = CarsFactory.createCars(
                String.format("%s,%s", testName0, testName1)
        );

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(1);
                    assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
                    assertThat(cars.getCars().get(1).getName()).isEqualTo("holy");
                    assertThat(cars.getCars().get(0).getMoveDistance()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getMoveDistance()).isEqualTo(0);
                },
                RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_STOP
        );
    }

    @Test
    void 차_여러번_이동() {
        String testName0 = "pobi";
        String testName1 = "holy";
        Cars cars = CarsFactory.createCars(
                String.format("%s,%s", testName0, testName1)
        );

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(3);
                    assertThat(cars.getCars().get(0).getMoveDistance()).isEqualTo(2);
                    assertThat(cars.getCars().get(1).getMoveDistance()).isEqualTo(1);
                },
                RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_STOP
                , RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_STOP
                , RANDOM_NUMBER_STOP, RANDOM_NUMBER_FORWARD
        );
    }

    @Test
    void 우승자_1대_반환() {
        String testWinnerName = "pobi";
        String testLoserName = "holy";
        Cars cars = CarsFactory.createCars(
                String.format("%s,%s", testWinnerName, testLoserName)
        );

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(1);
                    List<String> winnerNames = cars.findWinnerNames();
                    assertThat(winnerNames.size()).isEqualTo(1);
                    assertThat(winnerNames.get(0)).isEqualTo(testWinnerName);
                },
                RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_STOP
        );
    }

    @Test
    void 우승자_여러대_반환() {
        String testWinnerName1 = "pobi";
        String testWinnerName2 = "moly";
        String testWinnerName3 = "lulu";
        String testLoserName = "holy";
        Cars cars = CarsFactory.createCars(
                String.format("%s,%s,%s,%s", testWinnerName1, testWinnerName2, testWinnerName3, testLoserName));

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(1);
                    List<String> winnerNames = cars.findWinnerNames();
                    assertThat(winnerNames.size()).isEqualTo(3);
                    assertThat(winnerNames).isEqualTo(
                            new ArrayList<>(Arrays.asList(testWinnerName1, testWinnerName2, testWinnerName3))
                    );
                },
                RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_FORWARD, RANDOM_NUMBER_FORWARD,
                RANDOM_NUMBER_STOP
        );
    }
}
