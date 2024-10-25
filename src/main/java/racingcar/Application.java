package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.di.DefaultRacingCarTemplate;
import racingcar.di.RacingCarTemplate;

public class Application {

    private static final RacingCarTemplate racingCarTemplate = new DefaultRacingCarTemplate();
    private static final RacingCarController racingCarController = new RacingCarController(racingCarTemplate);

    public static void main(String[] args) {
        racingCarController.run();
    }
}
