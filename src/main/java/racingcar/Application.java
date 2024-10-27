package racingcar;

import racingcar.controller.RacingGame;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingGame racingGame = appConfig.racingGame();
        racingGame.startRace();
    }
}
