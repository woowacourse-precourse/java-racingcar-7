package racingcar;

import racingcar.console.InputView;
import racingcar.console.OutputView;
import racingcar.domain.Car;
import racingcar.exception.ExceptionHandler;
import racingcar.function.RacingGame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();

        RacingGame racingGame = new RacingGame(carNames, attemptCount);
        racingGame.run();

        List<Car> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}