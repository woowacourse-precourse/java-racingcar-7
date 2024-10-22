package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarController controller = new RacingcarController(new RacingcarService());
        controller.run();
    }
}
