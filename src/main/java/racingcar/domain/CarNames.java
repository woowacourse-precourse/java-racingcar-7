package racingcar.domain;

import static racingcar.domain.GameConstants.MAXIMUM_CAR_NAME_LENGTH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.ErrorMessage;
import racingcar.utils.Util;

public class CarNames {
    private final List<String> names;

    public CarNames(String carsName) {
        this.names = validateAndSplit(carsName);
    }

    private List<String> validateAndSplit(String carsName) {
        List<String> carNames = Util.splitByComma(carsName);

        if (carNames.isEmpty() || carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }

        carNames.forEach(this::validateName);

        return carNames;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
        if (name.length() >= MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }
        if (!name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }
    }

    public List<String> getNames() {
        return names;
    }
}
