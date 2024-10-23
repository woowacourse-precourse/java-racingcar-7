package racingcar.validator.strategies;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.constants.RacingGameConstants;
import racingcar.view.ErrorMessage;

public class CarNameValidator implements ValidationStrategy {

    @Override
    public void validate(String carNames) {
        validateNotNullOrEmpty(carNames);
        List<String> names = splitCarNames(carNames);
        validateCarNames(names);
        validateMinimumCarCount(names);
    }

    private void validateNotNullOrEmpty(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private List<String> splitCarNames(String carNames) {
        return Stream.of(carNames.split(",")).map(String::trim).collect(Collectors.toList());
    }

    private void validateCarNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(); // 중복 확인을 위한 Set

        for (String name : names) {
            validateNotEmpty(name);
            validateLength(name);
            validateNoDuplicates(nameSet, name);
        }
    }

    private void validateNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.length() > RacingGameConstants.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
    }

    private void validateNoDuplicates(Set<String> nameSet, String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    private void validateMinimumCarCount(List<String> names) {
        if (names.size() < RacingGameConstants.MINIMUM_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CARS.getMessage());
        }
    }

}
