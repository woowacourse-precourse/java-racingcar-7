package racingcar;

import racingcar.controller.ConsoleInputHandler;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new ConsoleInputHandler());
        racingController.run();
    }
}
