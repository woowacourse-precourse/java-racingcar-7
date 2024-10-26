package racingcar;

import racingcar.common.RealRandom;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(new RealRandom());
        racingGame.start();
    }
}
