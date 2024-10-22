package racingcar.config;

import racingcar.racingcar.RacingController;

public class Configuration {
    private static final Configuration CONFIGURATION = new Configuration();
    private final RacingController racingController;

    private Configuration() {
        this.racingController = RacingController.getInstance();
    }

    public static Configuration getInstance() {
        return CONFIGURATION;
    }

    public RacingController getRacingController() {
        return racingController;
    }
}
