package racingcar;

import racingcar.controller.RacingCarGameManager;

public class Application {
    public static void main(String[] args) {
        RacingCarGameManager racingCarGameManager = new RacingCarGameManager();
        racingCarGameManager.runGame();
    }
}
