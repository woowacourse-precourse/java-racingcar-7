package racingcar;

import racingcar.application.RacingCarService;
import racingcar.application.RacingCarServiceImpl;
import racingcar.presentation.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarServiceImpl();
        RacingCarController racingCarController = new RacingCarController(racingCarService);

        racingCarController.run();
    }
}
