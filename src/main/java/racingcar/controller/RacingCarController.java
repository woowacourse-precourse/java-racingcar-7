package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MoveNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Cars cars = createCars();
        MoveNumber moveNumber = createMoveNumber();
        outputRaceResult(cars, moveNumber);
    }

    private Cars createCars() {
        return new Cars(inputView.inputCarNames());
    }

    private MoveNumber createMoveNumber() {
        return new MoveNumber(inputView.inputMoveNumber());
    }

    private void outputRaceResult(Cars cars, MoveNumber moveNumber) {
        outputView.outputRaceStartLine();
        for (int i = 0; i < moveNumber.getMoveNumber(); i++) {
            outputView.outputRaceIntermediateResult(cars.moveCars());
        }
        outputView.outputRaceFinalResult(cars.findWinnerNames());
    }

}
