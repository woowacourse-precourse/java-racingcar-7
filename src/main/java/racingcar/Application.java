package racingcar;

import racingcar.config.Configuration;
import racingcar.racingcar.RacingCarController;
import racingcar.record.RecordController;

public class Application {
    private static final Configuration CONFIGURATION = Configuration.getInstance();

    public static void main(String[] args) {
        RacingCarController racingCarController = CONFIGURATION.getRacingCarController();
        RecordController recordController = CONFIGURATION.getRecordController();
        racingCarController.run();
        recordController.run();
    }
}
