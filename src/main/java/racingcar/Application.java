package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarView racingcarView = new RacingcarView();
        RacingcarService racingcarService = new RacingcarService();
        RacingcarController racingcarController = new RacingcarController(racingcarView, racingcarService);
        racingcarController.run();
    }
}
