package validator;

import exception.ErrorCode;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final int MAX_ROUND = Integer.MAX_VALUE;
    private static final int MIN_ROUND = 0;

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
            BigInteger round = new BigInteger(roundString);
            validateRange(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.ROUND_PARSE_ERROR.getMessage());
        }
    }

    private void validateRange(BigInteger round) {
        if (round.compareTo(BigInteger.valueOf(MAX_ROUND)) > 0) {
            throw new IllegalArgumentException(ErrorCode.ROUND_RANGE_ERROR.getMessage());
        }
        if (round.compareTo(BigInteger.valueOf(MIN_ROUND)) < 0) {
            throw new IllegalArgumentException(ErrorCode.ROUND_NEGATIVE_ERROR.getMessage());
        }
    }
}
