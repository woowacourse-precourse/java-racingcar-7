package racingcar;

import racingcar.game.RacingGame;
import racingcar.game.RacingGameFactory;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGameFactory.createRacingGame();

        racingGame.start();
    }
}
