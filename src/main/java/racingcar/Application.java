package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<String> carNames = InputView.inputCarNames();
            int rounds = InputView.inputRounds();
            RacingGame game = new RacingGame(carNames, rounds);
            game.startRace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
