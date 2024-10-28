package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.utils.StringConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        String receiveCarNames = receiveCarNames();
        RacingCar racingCar = new RacingCar(StringConvertor.toCarList(receiveCarNames));
        int trialCount = receiveTrialCount();
        playRace(racingCar, trialCount);
        racingResult(racingCar);

    }

    private String receiveCarNames() {
        outputView.requestCarNames();
        return inputView.inputCarName();
    }

    private int receiveTrialCount() {
        outputView.requestTrialCount();
        String inputTrialCount = inputView.inputTrialCount();
        return StringConvertor.toInt(inputTrialCount);
    }

    private void playRace(RacingCar racingCar, int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            racingCar.moving();
            outputView.printRacing(racingCar.getCars());
        }
    }

    private void racingResult(RacingCar cars) {
        outputView.printWinner(cars.getWinner());
    }
}
