package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView,
                               InputValidator inputValidator) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void run() {
        outputView.displayPrompt(1);
        String carNames = inputView.getInput();
        inputValidator.validateCarNames(carNames);
        outputView.displayPrompt(2);
        String attemptCount = inputView.getInput();
        inputValidator.validateAttemptCount(attemptCount);
        List<Car> cars = racingCarService.separateCarNames(carNames);
        int parsedCount = Integer.parseInt(attemptCount);

        for (int i = 0; i < parsedCount; i++) {
            racingCarService.updateLocation(cars);
            outputView.displayRacing(cars);
        }

        List<Car> winners = racingCarService.determineWinners(cars);
        outputView.displayWinners(winners);
    }
}
