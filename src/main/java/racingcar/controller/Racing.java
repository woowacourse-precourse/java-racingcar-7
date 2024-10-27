package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Racing {
    private InputView inputView;
    private OutputView outputView;
    private RacingManager racingManager;

    public Racing(InputView inputView, OutputView outputView, RacingManager racingManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingManager = racingManager;
    }

    public void start() {
        outputView.requestCarNameMessage();
        String carNames = inputView.getCarNames();
        outputView.requestNumberOfRoundsMessage();
        int numberOfRounds = inputView.getNumberOfRounds();
        List<Car> carList = racingManager.parseCarNamesToCar(carNames);
        outputView.raceStartMessage();

        for (int x = 0; x < numberOfRounds; x++) {
            racingManager.moveOrStop(carList);
            outputView.displayRaceProgress(carList);
        }
        List<Car> winnerList = racingManager.getWinners(carList);
        outputView.displayWinners(winnerList);
    }


}
