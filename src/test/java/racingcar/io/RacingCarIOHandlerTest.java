package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RaceCars;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarIOHandlerTest {

    private RacingCarIOHandler racingCarIOHandler;

    @BeforeEach
    void setup() {
        racingCarIOHandler = new RacingCarIOHandler();
    }

    @AfterEach
    void teardown() {
        Console.close();
    }

    @DisplayName("경주할 자동차를 입력 받는다.")
    @Test
    void askRaceCarsNames() {

        //given
        String input = "pobi,woni,jun,subin";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        RaceCars raceCars = racingCarIOHandler.askRaceCarsNames();

        //then
        assertThat(raceCars).isNotNull();
        assertThat(raceCars.size()).isEqualTo(4);
    }

    @DisplayName("경주할 자동차가 2개 미만이면 예외가 발생한다.")
    @Test
    void askRaceCarsNames_WhenCountIsLessThanTwo_ThrowsException() {

        //given
        String input = "pobi";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when & then
        assertThatThrownBy(() -> racingCarIOHandler.askRaceCarsNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 2개 이상이어야 합니다.");
    }

    @DisplayName("경주할 자동차의 이름이 5자를 초과하면 예외가 발생한다.")
    @Test
    void askRaceCarsNames_WhenNameLengthExceedsFive_ThrowsException() {

        //given
        String input = "pobi,woni,junnnnnn";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when & then
        assertThatThrownBy(() -> racingCarIOHandler.askRaceCarsNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차의 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("시도할 횟수를 입력 받는다.")
    @Test
    void askRaceCount() {

        //given
        String input = "3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        int raceCount = racingCarIOHandler.askRaceCount();

        //then
        assertThat(raceCount).isEqualTo(3);
    }

    @DisplayName("경주 횟수가 숫자가 아니면 예외가 발생한다.")
    @Test
    void askRaceCount_WhenCountIsNotNumber_ThrowsException() {

        //given
        String input = "다섯번";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when & then
        assertThatThrownBy(() -> racingCarIOHandler.askRaceCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 횟수는 숫자를 입력해야 합니다.");
    }

    @DisplayName("경주 횟수가 0이하이면 예외가 발생한다.")
    @Test
    void askRaceCount_WhenCountIsZeroOrLess_ThrowsException() {

        //given
        String input = "0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when & then
        assertThatThrownBy(() -> racingCarIOHandler.askRaceCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 횟수는 0이상을 입력해야 합니다.");
    }

    @DisplayName("실행 결과는 횟수별로 각 자동차의 경주 기록이 출력되어야 한다.")
    @Test
    void showExecutionResult() {

        //given
        String inputRaceCars = "pobi,woni,jun";
        String[] splitedInputRaceCars = inputRaceCars.split(",");
        RaceCars raceCars = RaceCars.addCars(splitedInputRaceCars);
        int raceCount = 5;
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        raceCars.initializeRaceRecords(raceCount);
        for (int round = 0; round < raceCount; round++) {
            race(raceCars, round);
        }

        //when
        racingCarIOHandler.showExecutionResult(raceCount, raceCars);

        //then
        String result = outputStream.toString();
        long pobiCount = result.lines()
                .filter(line -> line.contains("pobi : "))
                .count();
        long woniCount = result.lines()
                .filter(line -> line.contains("woni : "))
                .count();
        long junCount = result.lines()
                .filter(line -> line.contains("jun : "))
                .count();

        assertThat(pobiCount).isEqualTo(raceCount);
        assertThat(woniCount).isEqualTo(raceCount);
        assertThat(junCount).isEqualTo(raceCount);
    }

    @DisplayName("최종 우승자 한명을 출력한다.")
    @Test
    void showFinalWinner_WhenSingleWinner() {

        //given
        List<String> finalWinners = List.of("pobi");
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        racingCarIOHandler.showFinalWinner(finalWinners);

        //then
        String result = outputStream.toString().trim();
        assertThat(result).isEqualTo("최종 우승자 : pobi");
    }

    @DisplayName("최종 우승자 여러명을 출력한다.")
    @Test
    void showFinalWinner_WhenMutipleWinners() {

        //given
        List<String> finalWinners = List.of("pobi,woni,jun");
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        racingCarIOHandler.showFinalWinner(finalWinners);

        //then
        String result = outputStream.toString().trim();
        assertThat(result).isEqualTo("최종 우승자 : pobi,woni,jun");
    }

    private void race(RaceCars raceCars, int round) {
        for (int index = 0; index < raceCars.size(); index++) {
            Car car = raceCars.getCarByIndex(index);
            savePrevRecordToCurrentRound(car, round);
            moveForward(car, round);
        }
    }

    private void savePrevRecordToCurrentRound(Car car, int round) {
        if (round > 0) {
            car.recordPrevRaceByRound(round);
        }
    }

    private void moveForward(Car car, int round) {
        if (canMoveForward()) {
            car.moveForward(round);
        }
    }

    private boolean canMoveForward() {
        int moveForwardThreshold = getMoveForwardThreshold();
        return moveForwardThreshold >= 4;
    }

    private int getMoveForwardThreshold() {
        return Randoms.pickNumberInRange(0, 9);
    }
}