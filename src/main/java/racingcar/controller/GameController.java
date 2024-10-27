package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarHandler;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        resultWinnerList();
    }

    private void extractCarNames() {
        final String input = InputMessage.inputCarNames();
        validation.isInvalidInput(input);
        carHandler.createCar(input);
    }

    private void attemptGame() {
        final int num = InputMessage.inputGamesAttempts();
        validation.isInvalidGameTryCount(num);
        carHandler.executeRounds(num);
    }

    private void resultWinnerList() {
        final String carNames = carHandler.resultWinnerList();
        OutputMessage.executeResultMessage(carNames);
    }


}
