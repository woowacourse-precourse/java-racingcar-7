package racingcar.validator;

import static racingcar.validator.ErrorMessages.INVALID_CAR_COUNT;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;

public class CarCountValidator implements Validator<CarNames> {
    @Override
    public void validate(CarNames names) {
        validateHasAtLeastTwoNames(names);
    }

    private void validateHasAtLeastTwoNames(CarNames names) {
        if (names.getNames().size() <= 1) {
            throw new InvalidCarCountException(INVALID_CAR_COUNT.getMessage());
        }
    }
}
