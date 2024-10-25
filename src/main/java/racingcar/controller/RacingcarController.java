package racingcar.controller;

import racingcar.exception.ExceptionMessage;
import racingcar.exception.InvalidInputException;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final InputView inputView;

    public RacingcarController() {
        this.racingcarService = new RacingcarService();
        inputView = InputView.getInstance();
    }

    public void run() {
        String carName = inputView.getCarName();
        int attemptCount = 0;
        try {
            attemptCount = Integer.parseInt(inputView.getAttemptCount());
            InvalidInputException.validateAttemptCount(attemptCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }
        racingcarService.runRace(carName, attemptCount);
    }
}
