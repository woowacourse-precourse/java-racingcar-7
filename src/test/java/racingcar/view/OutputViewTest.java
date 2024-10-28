package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceRound;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private Car pobi;
    private Car woni;
    private Car jun;
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi");
        woni = new Car("woni");
        jun = new Car("jun");
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("자동차 경주 기록 출력")
    @Test
    void printRaceResult() {
        List<RaceRound> raceRounds = createRaceRounds();

        outputView.printRaceResult(raceRounds);

        String expectedOutput = String.format(
                "pobi : -%n" +
                        "jun : -%n" +
                        "woni : -%n" +
                        "%n" +
                        "pobi : --%n" +
                        "jun : -%n" +
                        "woni : --%n" +
                        "%n" +
                        "pobi : ---%n" +
                        "jun : -%n" +
                        "woni : --%n" +
                        "%n"
        );

        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("우승한 자동차 출력")
    @Test
    void winnerCarName() {
        outputView.printWinners("pobi");

        String expectedOutput = String.format("최종 우승자 : pobi%n");
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    private List<RaceRound> createRaceRounds() {
        List<RaceRound> raceRounds = new ArrayList<>();
        raceRounds.add(createFirstRound());
        raceRounds.add(createSecondRound());
        raceRounds.add(createThirdRound());
        return raceRounds;
    }

    private RaceRound createFirstRound() {
        List<Car> cars = new ArrayList<>();
        addResult(true, true, true);
        addCars(cars);
        return new RaceRound(cars);
    }

    private RaceRound createSecondRound() {
        List<Car> cars = new ArrayList<>();
        addResult(true, true, false);
        addCars(cars);
        return new RaceRound(cars);
    }

    private RaceRound createThirdRound() {
        List<Car> cars = new ArrayList<>();
        addResult(true, false, false);
        addCars(cars);
        return new RaceRound(cars);
    }

    private void addCars(List<Car> cars) {
        cars.add(pobi);
        cars.add(woni);
        cars.add(jun);
    }

    private void addResult(boolean pobiType, boolean woniType, boolean junType) {
        if (pobiType) {
            pobi.addResult();
        }
        if (woniType) {
            woni.addResult();
        }
        if (junType) {
            jun.addResult();
        }
    }
}