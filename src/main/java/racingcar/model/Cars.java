package racingcar.model;

import static racingcar.message.ErrorMessages.DUPLICATED_NAMES;
import static racingcar.message.ErrorMessages.UNPROVIDED_NAMES;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.InvalidInputException;

public class Cars {
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        String inputNames = inputCarNames.trim();
        validateUnprovidedNames(inputNames);

        String[] nameArray = inputNames.split(NAME_DELIMITER);
        validateDuplicatedNames(nameArray);

        this.cars = Arrays.stream(nameArray)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateUnprovidedNames(String names) {
        if (names == null || names.isEmpty()) {
            throw new InvalidInputException(UNPROVIDED_NAMES);
        }
    }

    private void validateDuplicatedNames(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new InvalidInputException(DUPLICATED_NAMES);
        }
    }
}
