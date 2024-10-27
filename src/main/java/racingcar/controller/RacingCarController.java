package racingcar.controller;

import racingcar.domain.CarsFactory;
import racingcar.domain.MoveNumberFactory;
import racingcar.domain.Cars;
import racingcar.domain.MoveNumber;
import racingcar.view.CarsIntermediateView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarsIntermediateView carsIntermediateView;

    protected RacingCarController(CarsIntermediateView carsIntermediateView) {
        this.carsIntermediateView = carsIntermediateView;
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
        return MoveNumberFactory.createMoveNumber(InputView.inputMoveNumber());
    }

    private void outputRaceResult(Cars cars, MoveNumber moveNumber) {
        OutputView.outputRaceStartLine();
        cars.registerObserver(carsIntermediateView);
        cars.moveCars(moveNumber.moveNumber());
        OutputView.outputRaceFinalResult(cars.findWinnerNames());
    }

}
