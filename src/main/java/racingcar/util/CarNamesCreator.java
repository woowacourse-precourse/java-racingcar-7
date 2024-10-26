package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class CarNamesCreator {

    private static final String COMMA = ",";

    public static List<String> createCarNames(String inputCarNames) {
        InputValidator.validateCarNames(inputCarNames);

        return Arrays.stream(splitInputCarNames(inputCarNames))
                .map(CarNamesCreator::stripCarName)
                .toList();
    }

    private static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(COMMA);
    }

    private static String stripCarName(String carName) {
        return carName.strip();
    }
}
