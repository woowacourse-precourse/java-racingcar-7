package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = InputView.getCarNames();
            int rounds = InputView.getRounds();
            RacingGame racingGame = new RacingGame(carNames, rounds);
            racingGame.start();
            OutputView.printWinners(racingGame.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
