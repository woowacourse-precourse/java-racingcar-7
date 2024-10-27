package racingcar;

import racingcar.controller.Game;
import racingcar.util.InputOutputHandler;

public class Application {
    public static void main(String[] args) {
        new Game(new InputOutputHandler()).play();
    }
}
