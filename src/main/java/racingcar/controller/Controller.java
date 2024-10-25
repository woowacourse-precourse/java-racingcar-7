package racingcar.controller;

import racingcar.model.CarStatus;
import racingcar.view.OutputView;

public class Controller {
    private final CarStatus carStatus;
    private final OutputView outputView;

    public Controller(CarStatus carStatus, OutputView outputView) {
        this.carStatus = carStatus;
        this.outputView = outputView;
    }

    public void playGame(int countOfRounds) {
        outputView.showResultMessage();
        for (int i = 0; i < countOfRounds; i++) {
            carStatus.moveCars();
            outputView.printCarPositions(carStatus.getCarNames(), carStatus.getCarPositions());
        }
        outputView.printWinners(carStatus.getWinners());
    }
}