package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNamesCreator {

    private static final String INPUT_CAR_NAMES_REGEX = "(\\s*\\w+\\s*)(,\\s*\\w+\\s*)*";
    private static final String COMMA = ",";

    public static List<String> createCarNames(String inputCarNames) {
        validateInputCarNamesRegex(inputCarNames);

        return Arrays.stream(splitInputCarNames(inputCarNames))
                .map(CarNamesCreator::stripCarName)
                .toList();
    }

    private static void validateInputCarNamesRegex(String inputCarNames) {
        if (!inputCarNames.matches(INPUT_CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 콤마로 구분해야 합니다");
        }
    }

    private static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(COMMA);
    }

    private static String stripCarName(String carName) {
        return carName.strip();
    }
}
