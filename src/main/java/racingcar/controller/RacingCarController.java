package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final OutputView outputView;

    public RacingCarController(RacingCarService racingCarService, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = processCarNames();
        int attemptCount = processAttemptCount();
        runRaces(cars, attemptCount);
        displayWinners(cars);
    }

    private List<Car> processCarNames() {
        outputView.displayPrompt(1);
        String carNames = InputView.getInput();
        InputValidator.validateCarNames(carNames);
        return racingCarService.separateCarNames(carNames);
    }

    private int processAttemptCount() {
        outputView.displayPrompt(2);
        String attemptCount = InputView.getInput();
        InputValidator.validateAttemptCount(attemptCount);
        return Integer.parseInt(attemptCount);
    }

    private void runRaces(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racingCarService.updateLocation(cars);
            outputView.displayRacing(cars);
        }
    }

    private void displayWinners(List<Car> cars) {
        List<Car> winners = racingCarService.determineWinners(cars);
        outputView.displayWinners(winners);
    }
}
