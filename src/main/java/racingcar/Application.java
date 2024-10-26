package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();
        RacingcarController racingcarController = new RacingcarController(racingService);
        racingcarController.getUserInput();
    }
}
