package racingcar.controller;

import racingcar.model.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.validation.RoundNumberValidator;
import racingcar.validation.CarNameValidator;

import java.util.List;

public class Controller {
    private final OutputView outputView;

    public Controller() {
        this.outputView = new OutputView();
    }

    public void playGame() {
        List<String> carNames = CarNameValidator.splitAndValidateCarNames(InputView.readCarNames());
        int numberOfRounds = RoundNumberValidator.parseAndValidateRoundNumber(InputView.readCountOfRounds());

        CarStatus carStatus = new CarStatus(carNames);

        outputView.showResultMessage();
        for (int i = 0; i < numberOfRounds; i++) {
            carStatus.playOneRound();
            outputView.printGameProgress(carStatus.getCarNames(), carStatus.getCarPositions());
        }
        outputView.showWinners(carStatus.getWinners());
    }
}