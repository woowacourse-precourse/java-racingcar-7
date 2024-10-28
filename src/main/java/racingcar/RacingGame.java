package racingcar;

import static racingcar.util.constant.MoveCarNumberConstant.TURN_NUMBER_START_WITH;

import racingcar.controller.GameController;
import racingcar.controller.GameControllerFactory;
import racingcar.model.Cars;
import racingcar.model.ExecutionNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final OutputView outputView;
    private final InputView inputView;
    private final GameController gameController;

    public RacingGame() {
        outputView = new OutputView();
        inputView = new InputView();
        gameController = GameControllerFactory.createGameController();
    }

    public void run() {
        Cars cars = registerCar(gameController);
        ExecutionNumber executionNumber = registerExecutionNumber(gameController);
        raceResult(gameController, executionNumber, cars);
    }

    private Cars registerCar(final GameController gameController) {
        final String input = inputView.registerCarInputView();
        return gameController.registerCars(input);
    }

    private ExecutionNumber registerExecutionNumber(final GameController gameController) {
        final String executionNumberInput = inputView.registerExecutionNumberInputView();
        ExecutionNumber executionNumber = gameController.registerExecutionNumber(executionNumberInput);
        outputView.newline();
        return executionNumber;
    }

    private void raceResult(final GameController gameController, final ExecutionNumber executionNumber, Cars cars) {
        outputView.executionResultMessage();
        Cars finalResults = resultsPerTurn(cars, executionNumber, TURN_NUMBER_START_WITH.getValue());
        outputView.finalWinnerMessage(gameController.raceResult(finalResults));
    }

    private Cars resultsPerTurn(final Cars cars, final ExecutionNumber executionNumber, final int turn) {
        if(turn == executionNumber.getNumber()) {
            return cars;
        }

        Cars results = gameController.race(cars);
        outputView.printResult(results);
        return resultsPerTurn(results, executionNumber, turn + 1);
    }
}
