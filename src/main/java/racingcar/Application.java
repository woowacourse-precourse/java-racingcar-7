package racingcar;

import racingcar.config.Configuration;
import racingcar.racingcar.RacingController;

public class Application {
    private static final Configuration CONFIGURATION = Configuration.getInstance();

    public static void main(String[] args) {
        RacingController racingController = CONFIGURATION.getRacingController();
        racingController.run();
    }
}
