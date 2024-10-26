package racingcar;

import racingcar.racing.controller.RacingGameManager;
import racingcar.racing.model.RacingGameConcreteFactory;

public class Application {
    public static void main(String[] args) {
        RacingGameConcreteFactory racingGameFactory = new RacingGameConcreteFactory();
        RacingGameManager racingGameManager = new RacingGameManager(racingGameFactory);
        racingGameManager.run();
    }
}
