package racingcar.config;

import racingcar.racingcar.RacingCarController;
import racingcar.record.RecordController;

public class Configuration {
    private static final Configuration CONFIGURATION = new Configuration();
    private final RacingCarController racingCarController;
    private final RecordController recordController;

    private Configuration() {
        this.racingCarController = RacingCarController.getInstance();
        this.recordController = RecordController.getInstance();
    }

    public static Configuration getInstance() {
        return CONFIGURATION;
    }

    public RacingCarController getRacingCarController() {
        return racingCarController;
    }

    public RecordController getRecordController() {
        return recordController;
    }
}
