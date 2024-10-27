package racingcar.model;

import static racingcar.message.ErrorMessages.UNPROVIDED_NAMES;

import java.util.List;
import racingcar.exception.InvalidInputException;

public class Cars {
    private final List<Car> cars;

    public Cars(String inputCarNames) {
        String inputNames = inputCarNames.trim();
        validateUnprovidedNames(inputNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateUnprovidedNames(String names) {
        if (names == null || names.isEmpty()) {
            throw new InvalidInputException(UNPROVIDED_NAMES);
        }
    }
}
