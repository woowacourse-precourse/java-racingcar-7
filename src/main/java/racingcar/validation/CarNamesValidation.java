package racingcar.validation;

import racingcar.exception.CarNamesException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNamesValidation {
    public static List<String> validateCarNames(String carNames) {
        isCarNamesEmpty(carNames);
        isCarNamesDelimiterValid(carNames);

        return convertCarNamesToList(carNames);
    }

    private static void isCarNamesEmpty(String carNames) {
        if (carNames.isBlank()) throw new CarNamesException(CarNamesException.MESSAGE_CAR_NAME_EMPTY);
    }

    private static void isCarNamesDelimiterValid(String carNames) {
        if (!carNames.matches("[^,]+(,[^,]+)*"))
            throw new CarNamesException(CarNamesException.MESSAGE_INVALID_DELIMITER);
    }

    private static List<String> convertCarNamesToList(String carNames) {
        List<String> namesList = Arrays.asList(carNames.split(","));

        isCarNameOverFive(namesList);
        isCarNamesDuplicate(namesList);

        return namesList;
    }

    private static void isCarNameOverFive(List<String> names) {
        for (String name : names)
            if (name.length() > 5) throw new CarNamesException(CarNamesException.MESSAGE_CAR_NAME_OVER_FIVE);
    }

    private static void isCarNamesDuplicate(List<String> names) {
        HashSet<String> nameSet = new HashSet<>();

        for (String name : names)
            if (!nameSet.add(name.trim())) throw new CarNamesException(CarNamesException.MESSAGE_DUPLICATE_CAR_NAME);
    }
}