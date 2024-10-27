package racingcar.racing;

import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final Computer computer;

    public RacingController() {
        this.computer = new Computer();
    }

    public void start() {
        initializeGame();

        race();

        announceWinners();
    }

    private void initializeGame() {
        List<Car> cars = InputView.readCarNames();
        int attemptTimes = InputView.readAttemptTimes();

        InputValidator.validateInputs(cars, attemptTimes);

        computer.prepareGame(cars, attemptTimes);
    }

    private void race() {
        OutputView.printResult();
        int totalRounds = computer.getAttemptTimes();

        for (int round = 0; round < totalRounds; round++) {
            computer.moveCars();
            OutputView.printRaceStatus(computer.getCars());
        }
    }

    private void announceWinners() {
        List<Car> winners = computer.determineWinners();
        OutputView.printWinners(winners);
    }
}
