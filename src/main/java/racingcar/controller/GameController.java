package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarHandler;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;

public class GameController {

    private final CarHandler carHandler;
    private final Validation validation;

    public GameController(final CarHandler carHandler, final Validation validation) {
        this.carHandler = carHandler;
        this.validation = validation;
    }

    public void start() {
        extractCarNames();
        attemptGame();
    }

    private void extractCarNames() {
        InputMessage.inputCarNames();
        final String input = Console.readLine();
        validation.isInvalidInput(input);
        carHandler.createCar(input);
    }

    private void attemptGame() {
        InputMessage.inputGamesAttempts();
        final int num = Integer.parseInt(Console.readLine());
        carHandler.proceedCar();
    }


}
