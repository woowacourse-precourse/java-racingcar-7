package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingGame = new RacingGame();
    }

    public void start() {
        List<Car> carList = initializeCars();
        int attemptCount = initializeAttempts();
        racingGame.setCars(carList);

        playRounds(attemptCount);
        displayResults();
    }

    private void playRounds(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racingGame.play();
            outputView.displayRaceProgress(racingGame.getCarList());
        }
    }

    private void displayResults() {
        outputView.displayWinners(racingGame.getCarList());
        outputView.displayExecutionResult();
    }

    private List<Car> initializeCars() {
        outputView.inputCarNames();
        return inputView.readCarNames();
    }

    private int initializeAttempts() {
        outputView.inputAttemptCount();
        return inputView.inputAttemptCount();
    }

}