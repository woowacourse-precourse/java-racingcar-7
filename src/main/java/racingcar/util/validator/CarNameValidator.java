package racingcar.util.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.ExceptionMessage.HOLE_IN_RAIN;
import static racingcar.util.ExceptionMessage.EMPTY_CAR;
import static racingcar.util.ExceptionMessage.CAR_NAME_DELIMITER;
import static racingcar.util.ExceptionMessage.DUPLICATE_CAR_NAME;

public class CarNameValidator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> getSplitCarName(String carName) {
        isFinishComma(carName);
        isCarZero(carName);
        List<String> carNames = Arrays.asList(carName.split(SPLIT_DELIMITER));
        Set<String> uniqueNames = new HashSet<>();

        validateCarName(carNames, uniqueNames);
        return carNames;
    }

    private static void validateCarName(List<String> carNames, Set<String> uniqueNames) {
        for (String name: carNames) {
            isCarEmpty(name);
            isLengthValid(name);
            isDuplicate(uniqueNames, name);
        }
    }

    private static void isFinishComma(String carName) {
        if (carName.endsWith(SPLIT_DELIMITER)) {
            throw new IllegalArgumentException(HOLE_IN_RAIN.format());
        }
    }

    private static void isCarZero(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR.format());
        }
    }

    private static void isCarEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(HOLE_IN_RAIN.format());
        }
    }

    private static void isLengthValid(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_DELIMITER.format());
        }
    }

    private static void isDuplicate(Set<String> uniqueNames, String carName) {
        if (!uniqueNames.add(carName)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.format());
        }
    }
}