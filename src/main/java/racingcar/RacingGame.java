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

    public void run() {
        GameController gameController = new GameController(
                new GameService(),
                new VerificationService(),
                new DataTransformService(),
                new InputView(),
                new OutputView()
        );

        // TODO : 일급 컬렉션으로
        List<Car> cars = gameController.registerCars();
        ExecutionNumber executionNumber = new ExecutionNumber(gameController.registerExecutionNumber());
        gameController.race(cars, executionNumber);
        gameController.raceResult(cars);
    }
}
