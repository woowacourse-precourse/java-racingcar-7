package racingcar.validate;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.constants.NumberConstants;
import racingcar.constants.RegexConstants;

public class Validator {

    public static ArrayList<String> getValidatedCarNames(String carNames) throws IllegalArgumentException {
        ArrayList<String> nameList = splitNamesByComma(carNames);
        validateNamesLength(nameList);
        validateNamesDuplicate(nameList);
        return nameList;
    }

    public static int getValidatedRepeatCount(String repeatCount) throws IllegalArgumentException {
        if (!repeatCount.matches(RegexConstants.INTEGER_PATTERN)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(repeatCount);
    }

    private static void validateNamesPattern(String carNames) throws IllegalArgumentException {
        if (!carNames.matches(RegexConstants.INPUT_CARS_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNamesLength(ArrayList<String> nameList) throws IllegalArgumentException {
        if (nameList.stream()
                .anyMatch(name -> name.isEmpty() || name.length() > NumberConstants.MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNamesDuplicate(ArrayList<String> nameList) throws IllegalArgumentException {
        if (nameList.stream().distinct().count() != nameList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static ArrayList<String> splitNamesByComma(String carNames) {
        validateNamesPattern(carNames);
        return new ArrayList<>(Arrays.asList(carNames.split(RegexConstants.COMMA)));
    }
}
