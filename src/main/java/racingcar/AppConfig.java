package racingcar;

import java.util.List;
import racingcar.application.converter.CarNamesConverter;
import racingcar.application.converter.CountConverter;
import racingcar.application.converter.InputStringConverter;
import racingcar.domain.car.Car;
import racingcar.domain.game.Display;
import racingcar.domain.car.ForwardPolicy;
import racingcar.application.RandomForwardPolicy;
import racingcar.io.DisplayImpl;
import racingcar.io.InputStringReader;
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
