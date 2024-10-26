package racingcar.controller;

import racingcar.model.CarFactory;
import racingcar.model.Cars;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        Cars cars = getParticipateRacingCars();
        int tryCount = getRacingTryCount();
        racing(cars, tryCount);
        winner(cars);
    }

    private static int getRacingTryCount() {
        OutputView.printInputTryCount();
        return Integer.parseInt(InputView.inputTryCount());
    }

    private static Cars getParticipateRacingCars() {
        OutputView.printInputCarName();
        String carNames = InputView.inputCarName();
        return new Cars(CarFactory.createCars(carNames));
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
