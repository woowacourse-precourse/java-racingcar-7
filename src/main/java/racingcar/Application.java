package racingcar;

import racingcar.manager.InputManager;
import racingcar.manager.RunManager;

public class Application {
    public static void main(String[] args) {
        RunManager runManager = new RunManager(new InputManager());
        runManager.run();
    }
}
