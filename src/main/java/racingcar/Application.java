package racingcar;

import racingcar.racingGame.RacingGame;
import racingcar.racingGame.RacingGameTemplate;

public class Application {
    public static void main(String[] args) {
        final RacingGameTemplate racingGame = RacingGame.initGame();
        racingGame.play();
    }
}
