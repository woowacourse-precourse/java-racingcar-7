package racingcar.utils;

import racingcar.exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtils {

    public static List<String> parseCarNames(String carName) {

        if (carName.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(InputException.EMPTY_RACING_CAR_NAME));
        }

        String[] carNames = carName.split(",");
        List<String> listOfCarNames = Arrays.stream(carNames)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();

        List<String> finalListOfCarNames = getCarNames(listOfCarNames);

        return finalListOfCarNames;
    }

    private static List<String> getCarNames(List<String> listOfCarNames) {
        List<String> finalListOfCarNames = new ArrayList<>();

        for (String individualCarName : listOfCarNames) {
            if (individualCarName.length() > 5) {
                throw new IllegalArgumentException(String.valueOf(InputException.TOO_LONG_RACING_CAR_NAME));
            }

            if (finalListOfCarNames.contains(individualCarName)) {
                throw new IllegalArgumentException(String.valueOf(InputException.DUPLICATE_RACING_CAR_NAME));
            }

            finalListOfCarNames.add(individualCarName);
        }
        
        return finalListOfCarNames;
    }

    public static int parseAttemptValue(String attemptValue) {

        if (attemptValue.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(InputException.ATTEMPT_VALUE_IS_EMPTY));
        }

        try {
            int finalAttemptValue = Integer.parseInt(attemptValue);

            if (finalAttemptValue == 0) {
                throw new IllegalArgumentException(String.valueOf(InputException.ATTEMPT_VALUE_IS_ZERO));
            } else if (finalAttemptValue < 0) {
                throw new IllegalArgumentException(String.valueOf(InputException.ATTEMPT_VALUE_IS_NEGATIVE));
            } else {
                return finalAttemptValue;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(InputException.ATTEMPT_VALUE_IS_INVALID));
        }

    }

}
