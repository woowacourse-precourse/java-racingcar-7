package racingcar;

import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
