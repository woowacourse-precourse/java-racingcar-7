package racingcar;

import java.util.List;
import racingcar.View.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.carNames();
        int moveAttemptCount = inputHandler.moveAttemptCount();
    }
}