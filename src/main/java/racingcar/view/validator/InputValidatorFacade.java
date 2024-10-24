package racingcar.view.validator;

import racingcar.view.validator.car.CarCountValidator;
import racingcar.view.validator.car.CarNameLengthValidator;
import racingcar.view.validator.lap.LapRegexValidator;
import racingcar.view.validator.lap.NumberFormatValidator;

public class InputValidatorFacade {

    public static void validateCarNames(String source) {
        CarCountValidator countValidator = CarCountValidator.initiate();
        CarNameLengthValidator lengthValidator = CarNameLengthValidator.initiate();

        countValidator.doChain(lengthValidator);

        countValidator.check(source);
    }

    public static void validateLapCount(String source) {
        LapRegexValidator regexValidator = LapRegexValidator.initiate();
        NumberFormatValidator formatValidator = NumberFormatValidator.initiate();

        regexValidator.doChain(formatValidator);

        regexValidator.check(source);
    }
}
