package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        new RacingGameController(new RandomNumberGenerator(), new RacingGameView()).start();
    }
}
