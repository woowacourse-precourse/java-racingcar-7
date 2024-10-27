package racingcar;

import racingcar.application.RandomForwardPolicy;
import racingcar.application.converter.CarNamesConverter;
import racingcar.application.converter.CountConverter;
import racingcar.application.validation.CarNameValidator;
import racingcar.application.validation.CountValidator;
import racingcar.application.validation.Validator;
import racingcar.domain.car.ForwardPolicy;
import racingcar.domain.game.Display;
import racingcar.io.DisplayImpl;
import racingcar.io.InputStringReader;

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

    public InputStringReader inputStringReader() {
        return new InputStringReader();
    }

    public CarNamesConverter carNamesConverter() {
        return new CarNamesConverter();
    }

    public CountConverter countConverter() {
        return new CountConverter();
    }
}
