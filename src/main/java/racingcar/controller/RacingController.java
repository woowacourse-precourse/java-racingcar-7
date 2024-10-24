package racingcar.controller;

import racingcar.model.CarFactory;
import racingcar.model.Cars;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        OutputView.printInputCarName();
        String carNames = InputView.inputCarName();
        Cars cars = new Cars(CarFactory.createCars(carNames));

        OutputView.printInputTryCount();
        int tryCount = Integer.parseInt(InputView.inputTryCount());

        racing(cars, tryCount);
        winner(cars);
    }

    private void winner(Cars cars) {
        Result result = new Result(cars.submitCarsStatus());
        OutputView.printWinner(result.findWinner());
    }

    private void racing(Cars cars, int tryCount) {
        OutputView.printExecuteResult();
        while (tryCount > 0) {
            cars.move();
            OutputView.printMoveStatus(cars.submitCarsStatus());
            tryCount--;
        }
    }

}
