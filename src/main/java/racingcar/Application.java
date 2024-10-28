package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputHandler.getCarNames();
        int maxRound = InputHandler.getMaxRound();
        RacingGame racingGame = new RacingGame(carNames, maxRound);
        racingGame.play();
    }
}
