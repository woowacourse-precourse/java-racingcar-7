package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameView racingGameView = new RacingGameView();
        RacingGame racingGame = new RacingGame();
        RacingController racingController = new RacingController(racingGameView, racingGame);

        racingController.runRacingGame();
    }
}
