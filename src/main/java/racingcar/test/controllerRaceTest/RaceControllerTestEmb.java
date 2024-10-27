package racingcar.test.controllerRaceTest;

import org.junit.jupiter.api.Test;
import racingcar.controller.race.RaceController;
import racingcar.service.factory.RaceControllerFactory;
import racingcar.service.factory.RaceControllerFactoryEmb;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTestEmb implements RaceControllerTest {
    @Test
    public void run() {
        try {
            RaceControllerFactory raceControllerFactory = new RaceControllerFactoryEmb();
            RaceController raceController = raceControllerFactory.createRaceController();
            String carNamesInput = "a,b,c";
            String roundsInput = "5";
            InputStream inputStream = new ByteArrayInputStream((carNamesInput + "\n" + roundsInput).getBytes());
            System.setIn(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            raceController.readyForRace();
            assertThat(raceController.isFinished()).isFalse();
            raceController.broadcastRace();
            assertThat(raceController.isFinished()).isTrue();
            raceController.announceWinner();
            String output = outputStream.toString();
            assertThat(output).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            assertThat(output).contains("시도할 횟수는 몇 회인가요?");
            assertThat(output).contains("실행 결과");
            String[] carNames = {"a", "b", "c"};
            int expectedRounds = 5;
            int expectedOutputCount = expectedRounds * carNames.length;
            int actualCount = 0;
            for (String carName : carNames) {
                actualCount += output.split(carName + " :").length - 1;
            }
            assertThat(actualCount).isEqualTo(expectedOutputCount);
            assertThat(output).contains("최종 우승자 : ");
        }catch (Exception e) {
            e.getMessage();
        }
    }
}