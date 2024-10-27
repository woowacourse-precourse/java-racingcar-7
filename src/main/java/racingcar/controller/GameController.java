package racingcar.controller;

import racingcar.model.Cars;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

public class GameController {

    private final Cars cars;

    public GameController(final Cars cars) {
        this.cars = cars;
    }

    public void start() {
        extractCarNames();
        attemptGame();
        resultWinnerList();
    }

    private void extractCarNames() {
        final String input = InputMessage.inputCarNames();
        Validation.validateInput(input);
        cars.createCars(input);
    }

    private void attemptGame() {
        final int num = InputMessage.inputGameAttempts();
        Validation.validateGameTryCount(num);
        cars.executeRounds(num);
    }

    private void resultWinnerList() {
        final String carNames = cars.getWinnerNames();
        OutputMessage.executeResultMessage(carNames);
    }

}
