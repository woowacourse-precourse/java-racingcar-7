package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();
        RacingGame racingGame = new RacingGame(carNames, rounds);
        racingGame.start();
        OutputView.printWinners(racingGame.getWinners());
    }
}
