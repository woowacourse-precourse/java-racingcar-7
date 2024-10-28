package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.OutputService;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        OutputService outputService = new OutputService();
        RacingService racingService = new RacingService(outputService);
        RacingcarController racingcarController = new RacingcarController(racingService);
        racingcarController.getUserInput();
    }
}
