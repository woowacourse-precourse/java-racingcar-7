package racingcar;

import racingcar.controller.RaceController;

public class Application {
    public static void main(final String... args) {
        RaceController raceController = new RaceController();
        raceController.playGame();
    }
}
