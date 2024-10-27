package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputView.getCarNames();
        int attempts = InputView.getAttempts();

        RacingGame racingGame = new RacingGame(cars, attempts);
        racingGame.play();

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
