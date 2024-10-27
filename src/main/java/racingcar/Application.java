package racingcar;

import java.io.IOException;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
