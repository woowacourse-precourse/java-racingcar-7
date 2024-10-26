package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.InputModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final InputModel inputModel = new InputModel();
    private final OutputView outputView = new OutputView();

    public void playGame(Cars cars) {
        inputView.printPlayTimesPrompt();
        int numberOfRounds = inputModel.getPlayTime();
        for (int i = 0; i < numberOfRounds; i++) {
            outputView.printRaceResultHeader();
            cars.play();
            outputView.printCarPositions(cars.getCars());
            System.out.println();
        }
    }
}
