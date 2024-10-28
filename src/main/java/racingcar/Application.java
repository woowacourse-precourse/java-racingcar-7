package racingcar;

import racingcar.config.AppConfig;
import racingcar.service.CarRacing;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CarRacing carRacing = appConfig.carRacing();
        carRacing.start();
        carRacing.finish();
    }
}