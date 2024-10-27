package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceCount;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("출력 테스트")
class RacingCarControllerTest extends IOTest {
    @Test
    @DisplayName("경주별 결과 출력")
    void printRaceResult() {
        RaceCount raceCount = new RaceCount(2);
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
        RacingCarController racingCarController = new RacingCarController();

        assertRandomNumberInRangeTest(
                () -> {
                    racingCarController.playRace(raceCount, cars);
                    assertThat(getOutput()).contains("pobi : -", "woni : ", "pobi : --", "woni : -");
                },
                4, 3, 4, 4
        );
    } // printRaceResult

    @Test
    @DisplayName("최종 우승자 출력 - 단독")
    void printWinner() {
        RaceCount raceCount = new RaceCount(2);
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
        RacingCarController racingCarController = new RacingCarController();

        assertRandomNumberInRangeTest(
                () -> {
                    racingCarController.playRace(raceCount, cars);
                    racingCarController.judgeWinnerCars(cars);
                    assertThat(getOutput()).contains("최종 우승자 : pobi");
                },
                4, 3, 4, 4
        );
    } // printWinner

    @Test
    @DisplayName("최종 우승자 출력 - 공동")
    void printWinners() {
        RaceCount raceCount = new RaceCount(1);
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
        RacingCarController racingCarController = new RacingCarController();

        assertRandomNumberInRangeTest(
                () -> {
                    racingCarController.playRace(raceCount, cars);
                    racingCarController.judgeWinnerCars(cars);
                    assertThat(getOutput()).contains("최종 우승자 : pobi, woni");
                },
                4, 4
        );
    } // printWinners
} // class