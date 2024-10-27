package racingcar.config;

import racingcar.model.Error.CarNameValidator;
import racingcar.model.Error.RaceCountValidator;
import racingcar.model.Util.Parser;

public class ValidatorFactory {

    public static CarNameValidator getCarNameValidator() {
        return new CarNameValidator(getParser());
    }

    public static RaceCountValidator getRaceNumValidator() {
        return new RaceCountValidator();
    }

    public static Parser getParser() {
        return new Parser();
    }
}
