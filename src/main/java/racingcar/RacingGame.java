package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.ExecutionNumber;
import racingcar.service.DataTransformService;
import racingcar.service.GameService;
import racingcar.service.VerificationService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingGame() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        GameController gameController = new GameController(
                new GameService(),
                new VerificationService(),
                new DataTransformService()
        );

        List<Car> cars = registerCar(gameController);
        ExecutionNumber executionNumber = registerExecutionNumber(gameController);
        raceResult(gameController, executionNumber, cars);
    }

    private List<Car> registerCar(final GameController gameController) {
        outputView.registerCarMessage();
        final String input = inputView.input();
        return gameController.registerCars(input);
    }

    private ExecutionNumber registerExecutionNumber(final GameController gameController) {
        outputView.registerExecutionNumberMessage();
        final String executionNumberInput = inputView.input();
        ExecutionNumber executionNumber = new ExecutionNumber(gameController.registerExecutionNumber(executionNumberInput));
        outputView.newline();
        return executionNumber;
    }

    private void raceResult(final GameController gameController, final ExecutionNumber executionNumber, List<Car> cars) {
        outputView.executionResultMessage();
        for (int turn = 0; turn < executionNumber.getNumber(); turn++) {
            cars.forEach(gameController::race);
            outputView.printResult(cars);
            outputView.newline();
        }
        outputView.finalWinnerMessage(gameController.raceResult(cars));
    }
}
