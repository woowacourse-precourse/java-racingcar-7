package racingcar;

import racingcar.config.AppConfiguration;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingCar = new AppConfiguration().racingController();
        racingCar.run();
    }
}
