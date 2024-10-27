package racingcar.config;

import racingcar.car.CarFactory;
import racingcar.io.Input;
import racingcar.io.View;

public class AppConfig {
    private static AppConfig INSTANCE;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppConfig();
        }
        return INSTANCE;
    }

    public Input createInput() {
        return new Input();
    }

    public View createView() {
        return  new View();
    }

    public CarFactory createCarFactory() {
        return new CarFactory();
    }
}
