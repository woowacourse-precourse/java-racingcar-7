package racingcar;

import racingcar.manager.InputManager;
import racingcar.manager.RacingManager;
import racingcar.manager.RunManager;
import racingcar.manager.WinnerManager;

public class Application {
    public static void main(String[] args) {
        RunManager runManager = new RunManager(new InputManager(), new RacingManager(), new WinnerManager());
        runManager.run();
    }
}
