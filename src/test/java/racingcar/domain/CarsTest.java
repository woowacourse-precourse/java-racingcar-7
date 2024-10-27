package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 객체_생성() {
        String testName1 = "car1";
        String testName2 = "car2";
        String testName3 = "car3";

        Cars cars = CarsFactory.createCars(
                String.format("%s,%s,%s", testName1, testName2, testName3)
        );

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo(testName1);
        assertThat(cars.getCars().get(1).getName()).isEqualTo(testName2);
        assertThat(cars.getCars().get(2).getName()).isEqualTo(testName3);
    }

    @Test
    void 차_전진_또는_정지() {
        String testName = "pobi,holy";
        int testRandomNumberForPobi = 4;
        int testRandomNumberForHoly = 0;
        Cars cars = CarsFactory.createCars(testName);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(1);
                    assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
                    assertThat(cars.getCars().get(1).getName()).isEqualTo("holy");
                    assertThat(cars.getCars().get(0).getMoveDistance()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getMoveDistance()).isEqualTo(0);
                },
                testRandomNumberForPobi, testRandomNumberForHoly
        );
    }

    @Test
    void 우승자_1대_반환() {
        String testWinnerName = "pobi";
        String testLoserName = "holy";
        int testRandomNumberForWinner = 4;
        int testRandomNumberForLoser = 0;
        Cars cars = CarsFactory.createCars(testWinnerName + "," + testLoserName);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars(1);
                    List<String> winnerNames = cars.findWinnerNames();
                    assertThat(winnerNames.size()).isEqualTo(1);
                    assertThat(winnerNames.get(0)).isEqualTo(testWinnerName);
                },
                testRandomNumberForWinner, testRandomNumberForLoser
        );
    }

    @Test
    void 우승자_여러대_반환() {
        String testWinnerName1 = "pobi";
        String testWinnerName2 = "moly";
        String testWinnerName3 = "lulu";
        String testLoserName = "holy";
        int testRandomNumberForWinner = 4;
        int testRandomNumberForLoser = 0;
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
                testRandomNumberForWinner, testRandomNumberForWinner, testRandomNumberForWinner,
                testRandomNumberForLoser
        );
    }
}
