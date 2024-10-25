package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceRound;
import racingcar.dto.ViewDto;

class RacingGameViewTest {

    private Car pobi;
    private Car woni;
    private Car jun;

    private RacingGameView racingGameView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        racingGameView = new RacingGameView();
    }

    @Test
    @DisplayName("게임 시작이 자동차 이름문자열 및 시도횟수 입력")
    void startGame() {
        setInput("pobi,woni,jun\n3\n");
        ViewDto viewDto = racingGameView.startGame();

        assertThat(viewDto.getCarName()).isEqualTo("pobi,woni,jun");
        assertThat(viewDto.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 종료시 결과 기록 및 우승자 출력")
    void endGame() {
        setCars();
        List<RaceRound> raceRounds = createRaceRounds();
        setOutPut();
        String expectedOutput = String.format(
                "실행 결과%n" +
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
                        "%n" +
                        "최종 우승자 : pobi%n"
        );

        racingGameView.endGame(raceRounds, "pobi");
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    private void setCars() {
        pobi = new Car("pobi");
        woni = new Car("woni");
        jun = new Car("jun");
    }

    private void setInput(String value) {
        ByteArrayInputStream in = new ByteArrayInputStream(value.getBytes());
        System.setIn(in);
    }

    private void setOutPut() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
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