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

        // TODO : 일급 컬렉션으로
        List<Car> cars = registerCar(gameController);
        ExecutionNumber executionNumber = registerExecutionNumber(gameController);
        raceResult(gameController, executionNumber, cars);
    }

    private List<Car> registerCar(GameController gameController) {
        outputView.carRegistMessage();
        final String input = inputView.input();
        return gameController.registerCars(input);
    }

    private ExecutionNumber registerExecutionNumber(GameController gameController) {
        outputView.countRegistMessage();
        final String executionNumberInput = inputView.input();
        ExecutionNumber executionNumber = new ExecutionNumber(gameController.registerExecutionNumber(executionNumberInput));
        outputView.newline();
        return executionNumber;
    }

    private void raceResult(GameController gameController, ExecutionNumber executionNumber, List<Car> cars) {
        outputView.executionMessage();
        for (int turn = 0; turn < executionNumber.getNumber(); turn++) {
            cars.forEach(gameController::race);
            outputView.printResult(cars);
            outputView.newline();
        }
        outputView.finalWinnerMessage(gameController.raceResult(cars));
    }
}
