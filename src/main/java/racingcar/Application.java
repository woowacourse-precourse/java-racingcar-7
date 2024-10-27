package racingcar;

import racingcar.racing.controller.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.run();
    }
}
