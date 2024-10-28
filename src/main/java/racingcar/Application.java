package racingcar;

import racingcar.domain.Game;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputHandler(), new OutputHandler());
        game.start();
    }
}
