package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;

public class Application {

    public static void main(String[] args) {
        RacingCarService service = new RacingCarService();
        RacingCarController controller = new RacingCarController(service);
        controller.startGame();
    }
}
