package racingcar;

import racingcar.controller.RacingGame;
import racingcar.controller.RacingSetUp;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RacingSetUp racingSetUp = new RacingSetUp();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        RacingGame racingGame = new RacingGame(racingSetUp, moveStrategy);
        racingGame.start();
    }
}
