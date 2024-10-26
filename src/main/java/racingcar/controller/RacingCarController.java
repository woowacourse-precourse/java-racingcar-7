package racingcar.controller;

import racingcar.factory.CarsFactory;
import racingcar.factory.NumberFactory;
import racingcar.model.Cars;
import racingcar.model.MoveNumber;
import racingcar.view.CarsOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarsOutputView carsOutputView;

    public RacingCarController(CarsOutputView carsOutputView) {
        this.carsOutputView = carsOutputView;
    }

    public void run() {
        Cars cars = createCars();
        MoveNumber moveNumber = createMoveNumber();
        outputRaceResult(cars, moveNumber);
    }

    private Cars createCars() {
        return CarsFactory.createCars(InputView.inputCarNames());
    }

    private MoveNumber createMoveNumber() {
        return NumberFactory.createMoveNumber(InputView.inputMoveNumber());
    }

    private void outputRaceResult(Cars cars, MoveNumber moveNumber) {
        OutputView.outputRaceStartLine();
        cars.registerObserver(carsOutputView);
        cars.moveCars(moveNumber.getMoveNumber());
        OutputView.outputRaceFinalResult(cars.findWinnerNames());
    }

}
