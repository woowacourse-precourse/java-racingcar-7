package racingcar.controller;

import racingcar.model.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.RoundNumberValidator;
import racingcar.util.CarNameValidator;

import java.util.List;

public class Controller {
    private final OutputView outputView;

    public Controller() {
        this.outputView = new OutputView();
    }

    public void playGame() {
        List<String> carNames = CarNameValidator.getSplitCarName(InputView.readCarNames());
        int numberOfRounds = RoundNumberValidator.parseToInt(InputView.readCountOfRounds());

        CarStatus carStatus = new CarStatus(carNames);

        outputView.showResultMessage();
        for (int i = 0; i < numberOfRounds; i++) {
            carStatus.moveCars();
            outputView.printCarPositions(carStatus.getCarNames(), carStatus.getCarPositions());
        }
        outputView.printWinners(carStatus.getWinners());
    }
}