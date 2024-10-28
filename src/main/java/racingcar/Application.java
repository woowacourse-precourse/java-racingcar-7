package racingcar;

import racingcar.controller.GameController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController game = new GameController(new Input(), new Output());
        game.start();
    }
}
