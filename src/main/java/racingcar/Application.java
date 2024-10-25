package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController(new RacingcarService());

        racingcarController.start();
        racingcarController.play();
        racingcarController.result();
    }
}
