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
        String carNamesInput = inputView.inputCarNames();
        Cars cars = new Cars();
        cars.registerCars(carNamesInput);

        MoveNumber moveNumber = new MoveNumber(inputView.inputMoveNumber());

        outputView.outputRaceStartLine();
        for (int i = 0; i < moveNumber.getMoveNumber(); i++) {
            cars.moveCars();
            outputView.outputRaceIntermediateReuslt(cars.getCars());
        }
        outputView.outputRaceFinalResult(cars.findWinnerNames());

    }
}
