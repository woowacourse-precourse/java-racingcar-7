package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void start() {
        List<String> carNames = InputView.getCarNames();
        int numberOfAttempts = InputView.getNumberOfAttempts();
        RacingGame racingGame = new RacingGame(carNames, numberOfAttempts);

        System.out.println("\n실행결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            racingGame.implement();
            OutputView.printRoundResult(racingGame.getParticipatingCars());
        }

        List<String> winners = racingGame.getWinnerNames();
        OutputView.printWinners(winners);
    }
}
