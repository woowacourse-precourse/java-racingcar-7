package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingGameView racingGameView = new RacingGameView();
        RacingGameController racingGameController = new RacingGameController(randomNumberGenerator, racingGameView);
        racingGameController.startGame();
    }
}
