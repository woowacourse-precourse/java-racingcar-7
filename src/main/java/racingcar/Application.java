package racingcar;

import racingcar.racing.controller.RacingGame;
import racingcar.racing.model.RacingGameConcreteFactory;

public class Application {
    public static void main(String[] args) {
        RacingGameConcreteFactory racingGameFactory = new RacingGameConcreteFactory();
        RacingGame racingGame = new RacingGame(racingGameFactory);
        racingGame.start();
    }
}
