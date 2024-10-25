package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarHandler;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

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
        InputMessage.inputCarNames();
        final String input = Console.readLine();
        validation.isInvalidInput(input);
        carHandler.createCar(input);
    }

    private void attemptGame() {
        InputMessage.inputGamesAttempts();
        final int num = Integer.parseInt(Console.readLine());
        OutputMessage.resultMessage();
        carHandler.executeRounds(num);
    }

    private void resultWinnerList() {
        String carNames = carHandler.getWinnerList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        OutputMessage.executeResultMessage(carNames);
    }


}
