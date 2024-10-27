package racingcar;

import racingcar.controller.RacingGame;
import racingcar.controller.RacingSetUp;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RacingSetUp());
        racingGame.start();
    }
}
