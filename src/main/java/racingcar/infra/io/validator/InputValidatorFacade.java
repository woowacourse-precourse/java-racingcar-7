package racingcar.infra.io.validator;

import racingcar.infra.io.validator.car.CarCountValidator;
import racingcar.infra.io.validator.car.CarNameLengthValidator;

public class InputValidatorFacade {

    public static void validateCarNames(String source) {
        CarCountValidator countValidator = CarCountValidator.initiate();
        CarNameLengthValidator lengthValidator = CarNameLengthValidator.initiate();

        countValidator.doChain(lengthValidator);

        countValidator.check(source);
    }
}
