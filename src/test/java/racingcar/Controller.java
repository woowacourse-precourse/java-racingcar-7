package racingcar;

import java.util.List;

public class Controller {
    public void startGame() {
        String carNameInput = InputView.readCarNames();
        List<Car> cars = InputProcessor.parseToCarNameList(carNameInput);

        String attemptCountInput = InputView.readAttemptCount();
        int attemptCount = InputProcessor.parseToAttemptCount(attemptCountInput);

        for (int i = 0; i < attemptCount; i++) {
            RacingGame.playRace(cars);
            ResultView.printRaceResult(cars);
        }

        List<Car> winners = Winners.findWinner(cars);
        ResultView.printWinners(winners);
    }
}
