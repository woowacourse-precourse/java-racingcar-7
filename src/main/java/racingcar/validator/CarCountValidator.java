package racingcar.validator;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;

public class CarCountValidator implements Validator<CarNames> {
    @Override
    public void validate(CarNames names) {
        validateHasAtLeastTwoNames(names);
    }

    private void validateHasAtLeastTwoNames(CarNames names) {
        if (names.getNames().size() <= 1) {
            throw new InvalidCarCountException("경주를 위해서 2개 이상의 차가 필요합니다.");
        }
    }
}
