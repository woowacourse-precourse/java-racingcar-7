package racingcar;

import racingcar.domain.game.Display;
import racingcar.domain.car.ForwardPolicy;
import racingcar.application.RandomForwardPolicy;
import racingcar.io.DisplayImpl;
import racingcar.io.InputReader;
import racingcar.io.validation.CarNameValidator;
import racingcar.io.validation.CountValidator;
import racingcar.io.validation.Validator;

public class AppConfig {

    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public Validator carNameValidator() {
        return new CarNameValidator();
    }

    public Validator countValidator() {
        return new CountValidator();
    }

    public Display display() {
        return new DisplayImpl();
    }

    public ForwardPolicy forwardPolicy() {
        return new RandomForwardPolicy();
    }

    public InputReader inputReader() {
        return new InputReader();
    }
}
