package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingCarService racingCarService = new RacingCarService(racingCarView);
        RacingCarController racingCarController = new RacingCarController(racingCarService, racingCarView);


        racingCarController.CarRacingStart();

    }
}
