package racingcar;

import racingcar.controller.io.ConsoleInputHandler;
import racingcar.controller.io.ConsoleOutputHandler;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new ConsoleInputHandler(), new ConsoleOutputHandler());
        racingController.run();
    }
}
