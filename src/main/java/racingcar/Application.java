package racingcar;

import racingcar.controller.RacingController;
import racingcar.di.DefaultRacingCarTemplate;
import racingcar.di.RacingCarTemplate;

public class Application {

    private static final RacingCarTemplate racingCarTemplate = new DefaultRacingCarTemplate();
    private static final RacingController racingCarController = new RacingController(racingCarTemplate);

    public static void main(String[] args) {
        racingCarController.setUpRacingCars();
        racingCarController.setUpTryCount();
        racingCarController.playRacing();
        racingCarController.printRacingResult();
    }
}
