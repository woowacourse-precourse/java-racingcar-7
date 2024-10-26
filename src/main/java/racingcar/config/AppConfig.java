package racingcar.config;

import racingcar.domain.CarFactory;
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
        return Input.getInstance();
    }

    public View createView() {
        return View.getInstance();
    }

    public CarFactory createCarFactory() {
        return new CarFactory();
    }
}
