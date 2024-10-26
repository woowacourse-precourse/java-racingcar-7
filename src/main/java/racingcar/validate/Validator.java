package racingcar.validate;

import java.util.ArrayList;
import racingcar.Util.Utils;
import racingcar.constants.NumberConstants;
import racingcar.constants.RegexConstants;

public class Validator {

    public static void validateCarNames(String carNames) throws IllegalArgumentException {
        validateNamesPattern(carNames);
        validateNamesLength(carNames);
        validateNamesDuplicate(carNames);
    }

    private static void validateNamesPattern(String carNames) throws IllegalArgumentException {
        if (!carNames.matches(RegexConstants.INPUT_CARS_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNamesLength(String carNames) throws IllegalArgumentException {
        ArrayList<String> nameList = Utils.splitNamesByComma(carNames);
        if (nameList.stream()
                .anyMatch(name -> name.isEmpty() || name.length() > NumberConstants.MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNamesDuplicate(String carNames) throws IllegalArgumentException {
        ArrayList<String> nameList = Utils.splitNamesByComma(carNames);
        if (nameList.stream().distinct().count() != nameList.size()) {
            throw new IllegalArgumentException();
        }
    }
}
