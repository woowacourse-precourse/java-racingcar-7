package racingcar;

import racingcar.controller.GameController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameView);

        gameController.run();
    }
}
