package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.ExecutionNumber;
import racingcar.service.RaceService;
import racingcar.service.RegisterCarService;
import racingcar.service.RegisterExecutionNumberService;
import racingcar.util.DataTransformUtil;
import racingcar.service.GameService;
import racingcar.util.ValidationUtil;
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
                new RegisterCarService(new ValidationUtil(), new DataTransformUtil()),
                new RegisterExecutionNumberService(new ValidationUtil(), new DataTransformUtil()),
                new RaceService(new GameService())
        );

        List<Car> cars = registerCar(gameController);
        ExecutionNumber executionNumber = registerExecutionNumber(gameController);
        raceResult(gameController, executionNumber, cars);
    }

    private List<Car> registerCar(final GameController gameController) {
        final String input = inputView.registerCarInputView();
        return gameController.registerCars(input);
    }

    private ExecutionNumber registerExecutionNumber(final GameController gameController) {
        final String executionNumberInput = inputView.registerExecutionNumberInputView();
        ExecutionNumber executionNumber = new ExecutionNumber(gameController.registerExecutionNumber(executionNumberInput));
        outputView.newline();
        return executionNumber;
    }

    private void raceResult(final GameController gameController, final ExecutionNumber executionNumber, List<Car> cars) {
        outputView.executionResultMessage();
        for (int turn = 0; turn < executionNumber.getNumber(); turn++) {
            cars.forEach(gameController::race);
            outputView.printResult(cars);
        }
        outputView.finalWinnerMessage(gameController.raceResult(cars));
    }
}
