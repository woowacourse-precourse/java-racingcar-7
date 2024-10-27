package racingcar.parser;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

public class InputParserFactory {
    public static InputParser create() {
        CarNameValidator carNameValidator = new CarNameValidator();
        TryCountValidator tryCountValidator = new TryCountValidator();
        return new InputParser(carNameValidator, tryCountValidator);
    }
}
