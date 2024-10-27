package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Game;

public class Application {

    public static void main(String[] args) {
        GameController.getInstance().startGame();
    }
}
