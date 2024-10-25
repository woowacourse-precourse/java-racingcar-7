package racingcar.validator;

import static racingcar.common.Constant.CAR_NAME_LIMIT_LENGTH;
import static racingcar.common.Constant.DELIMITER;
import static racingcar.validator.ValidationMessage.DUPLICATE_CAR_NAMES;
import static racingcar.validator.ValidationMessage.INVALID_CAR_NAMES_INPUT;
import static racingcar.validator.ValidationMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.validator.ValidationMessage.INVALID_DELIMITER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNameValidator {

    public void validate(String input) {
        validNotEmpty(input);
        validDelimiter(input);
        List<String> carNames = splitAndTrimCarNames(input);
        validAtLeastTwoCars(carNames);
        validLength(carNames);
        validDuplicate(carNames);
    }

    private void validNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_INPUT.getMessage());
        }
    }

    private void validDelimiter(String input) {
        if (!input.contains(DELIMITER.getValue())) {
            throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
        }
    }

    private void validAtLeastTwoCars(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_INPUT.getMessage());
        }
    }

    private void validLength(List<String> carNames) {
        if (isInvalidLength(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private void validDuplicate(List<String> carNames) {
        Set<String> setCarNames = new HashSet<>(carNames);
        if (setCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES.getMessage());
        }
    }

    private boolean isInvalidLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch(carName -> carName.length() > Integer.parseInt(CAR_NAME_LIMIT_LENGTH.getValue()));
    }

    private List<String> splitAndTrimCarNames(String input) {
        return Arrays.stream(input.split(DELIMITER.getValue()))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

}
