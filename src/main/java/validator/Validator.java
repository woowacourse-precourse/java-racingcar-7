package validator;

import exception.ErrorCode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LIMIT_NAME_LENGTH = 5;

    public void validateCar(List<String> carNames) {
        checkCarNotEmpty(carNames);
        checkLimitLengthName(carNames);
        checkDuplicateName(carNames);
    }

    private void checkCarNotEmpty(List<String> carNames) {
        if (carNames.stream().anyMatch(
                String::isEmpty)) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_CAR_NAME.getMessage());
        }
    }

    private void checkLimitLengthName(List<String> carNames) {
        if (carNames.stream().anyMatch(
                name -> LIMIT_NAME_LENGTH < name.length())) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_LIMIT.getMessage());
        }
    }

    private void checkDuplicateName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            String lowerCaseName = name.toLowerCase();
            if (!uniqueNames.add(lowerCaseName)) {
                throw new IllegalArgumentException(ErrorCode.DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }

    public void validateRound(String roundString) {
        try {
            long round = Long.parseLong(roundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.ROUND_PARSE_ERROR.getMessage());
        }
    }
}
