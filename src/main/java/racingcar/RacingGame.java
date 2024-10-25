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

    private OutputView outputView;
    private InputView inputView;

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

        outputView.carRegistMessage();
        final String input = inputView.input();
        // TODO : 일급 컬렉션으로
        List<Car> cars = gameController.registerCars(input);

        outputView.countRegistMessage();
        final String executionNumberInput = inputView.input();
        ExecutionNumber executionNumber = new ExecutionNumber(gameController.registerExecutionNumber(executionNumberInput));
        outputView.newline();

        outputView.executionMessage();
        for (int turn = 0; turn < executionNumber.getNumber(); turn++) {
            cars.forEach(car -> gameController.race(car));
            outputView.printResult(cars);
            outputView.newline();
        }
        outputView.finalWinnerMessage(gameController.raceResult(cars));
    }
}
