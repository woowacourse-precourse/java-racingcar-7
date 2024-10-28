package racingcar;

import racingcar.controller.RacingGame;

public class Application {
    private static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        racingGame.doGame();
    }
}
