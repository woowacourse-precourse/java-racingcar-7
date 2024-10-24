package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Game;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        // TODO: 프로그램 구현
        gameController.gameInput();
        gameController.gameProgress();
        gameController.gameResult();
    }
}
