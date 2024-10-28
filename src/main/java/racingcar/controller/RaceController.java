package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public void startGame() {
        String carNamesInput = inputCarNames();
        Cars cars = new Cars(carNamesInput);

        String attemptsInput = inputNumberOfAttempts();
        Attempts attempts = new Attempts(attemptsInput);

        CarRace carRace = new CarRace(cars, attempts);
        OutputView.printStartGame();

        while (attempts.isEndGame()) {
            carRace.runRace();
            OutputView.printCarPositions(cars.getCars());
            attempts.comsumeAttempt();
        }

        OutputView.printWinners(carRace.getWinners());
    }

    private String inputCarNames() {
        return InputView.getListOfCarNames();
    }

    private String inputNumberOfAttempts() {
        return InputView.getInputNumberOfAttempts();
    }
}
