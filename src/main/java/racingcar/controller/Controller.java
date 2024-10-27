package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.InputProcessor;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Controller {
    public void startGame() {
        List<Car> cars = parseCarListFromInput();
        int attemptCount = parseAttemptCountFromInput();

        playRaces(attemptCount, cars);
        displayWinners(cars);
    }

    private List<Car> parseCarListFromInput() {
        String carNameInput = InputView.readCarNames();
        return InputProcessor.parseToCarNameList(carNameInput);
    }

    private int parseAttemptCountFromInput() {
        String attemptCountInput = InputView.readAttemptCount();
        return InputProcessor.parseToAttemptCount(attemptCountInput);
    }

    private void playRaces(int attemptCount, List<Car> cars) {
        for (int i = 0; i < attemptCount; i++) {
            RacingGame.playRace(cars);
            ResultView.printRaceResult(cars);
        }
    }

    private void displayWinners(List<Car> cars) {
        List<Car> winners = Winners.findWinner(cars);
        ResultView.printWinners(winners);
    }
}