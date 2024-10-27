package racingcar;

import racingcar.io.InputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.inputCarName();
        int count = inputHandler.inputCount();
    }
}
