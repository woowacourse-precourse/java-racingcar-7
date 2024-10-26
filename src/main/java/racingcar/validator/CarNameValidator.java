package racingcar.validator;

import racingcar.domain.Car;
import racingcar.exception.GameErrorMessage;

import java.util.List;

public class CarNameValidator {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;

    public void validateCarNameLength(final String name) {
        if (name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(GameErrorMessage.CAR_NAME_EXISTS_AND_LIMIT_ERROR.getValue());
        }
    }

    public void validateCarNamesUnique(final List<Car> carList) {
        long distinctCount = carList.stream().map(Car::getName).distinct().count();
        if (distinctCount != carList.size()) {
            throw new IllegalArgumentException(GameErrorMessage.CAR_NAME_DUPLICATED.getValue());
        }
    }
}
