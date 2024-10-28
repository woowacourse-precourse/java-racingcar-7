package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameView view = new RacingGameView();
        RacingGame model = new RacingGame();
        RacingGameController controller = new RacingGameController(model, view);

        controller.runGame();
    }
}