package racingcar.model;

import static racingcar.message.ErrorMessages.DUPLICATED_NAMES;
import static racingcar.message.ErrorMessages.UNPROVIDED_NAMES;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.InvalidInputException;

public class Cars {
    private static final String NAME_DELIMITER = ",";
    private static final int MIN_DISTANCE = 0;
    private static final int MAX_DISTANCE = 9;

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        String inputNames = Objects.requireNonNullElse(inputCarNames, "").trim();
        validateUnprovidedNames(inputNames);

        List<String> names = Arrays.stream(inputNames.split(NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        validateDuplicatedNames(names);

        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        int randomValue = Randoms.pickNumberInRange(MIN_DISTANCE, MAX_DISTANCE);
        car.move(randomValue);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    private void validateUnprovidedNames(final String names) {
        if (names.isBlank()) {
            throw new InvalidInputException(UNPROVIDED_NAMES);
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new InvalidInputException(DUPLICATED_NAMES);
        }
    }
}
