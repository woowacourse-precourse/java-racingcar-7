package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
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

        String moveNumberInput = inputView.inputMoveNumber();
        Race race = new Race(moveNumberInput);

        outputView.outputRaceStartLine();
        cars.moveCars();

    }
}
