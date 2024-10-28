package racingcar;

import racingcar.service.Game;
import racingcar.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Game game = new Game(inputHandler);
        game.initialize();
    }
}
