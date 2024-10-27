package racingcar.domain.console;

import racingcar.domain.racingcar.presentation.RaceController;
import racingcar.domain.racingcar.service.RaceService;
import racingcar.domain.racingcar.domain.Race;
import racingcar.domain.console.util.ConsoleReader;
import racingcar.domain.console.util.ConsoleWriter;

import java.util.Arrays;
import java.util.List;

public class RaceConsole {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUNDS_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private final RaceController controller = RaceController.getInstance(RaceService.getInstance());

    public void run() {
        final List<String> carNames = inputCarNames();
        int rounds = inputRounds();
        final Race race = controller.createRace(carNames, rounds);

        ConsoleWriter.write(RESULT_MESSAGE);
        while (!controller.isRaceFinished(race)) {
            controller.moveAllCars(race);
            printRaceStatus(race);
        }

        printWinners(race);
    }

    private List<String> inputCarNames() {
        ConsoleWriter.write(CAR_NAMES_REQUEST_MESSAGE);
        return Arrays.asList(ConsoleReader.read().split(","));
    }

    private int inputRounds() {
        ConsoleWriter.write(ROUNDS_REQUEST_MESSAGE);
        return Integer.parseInt(ConsoleReader.read());
    }

    private void printRaceStatus(Race race) {
        for (String status : controller.getRaceStatus(race)) {
            ConsoleWriter.write(status);
        }
        ConsoleWriter.write("");
    }

    private void printWinners(Race race) {
        ConsoleWriter.write(WINNER_MESSAGE + String.join(", ", controller.getWinners(race)));
    }
}