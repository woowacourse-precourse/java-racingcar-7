package racingcar;

import racingcar.controller.ConsoleInputHandler;
import racingcar.controller.ConsoleOutputHandler;
import racingcar.controller.RacingController;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new ConsoleInputHandler(), new ConsoleOutputHandler());
        racingController.run();
    }
}
