package racingcar.controller;

import racingcar.model.CarHandler;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

public class GameController {

    private final CarHandler carHandler;

    public GameController(final CarHandler carHandler) {
        this.carHandler = carHandler;
    }

    public void start() {
        extractCarNames();
        attemptGame();
        resultWinnerList();
    }

    private void extractCarNames() {
        final String input = InputMessage.inputCarNames();
        Validation.validateInput(input);
        carHandler.createCars(input);
    }

    private void attemptGame() {
        final int num = InputMessage.inputGameAttempts();
        Validation.validateGameTryCount(num);
        carHandler.executeRounds(num);
    }

    private void resultWinnerList() {
        final String carNames = carHandler.getWinnerNames();
        OutputMessage.executeResultMessage(carNames);
    }

}
