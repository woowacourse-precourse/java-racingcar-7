package racingcar.util;

import java.util.List;

public class CarNameSeparator {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final Integer EMPTY_CAR_NAME_HANDLER = -1;

    public static List<String> splitCarNameWithSeparator(String carNames) {
        return List.of(carNames.split(CAR_NAME_SEPARATOR, EMPTY_CAR_NAME_HANDLER));
    }

    public static List<String> splitCarNameWithoutSpace(String carNamesWithSpace) {
        return splitCarNameWithSeparator(carNamesWithSpace)
                .stream()
                .map(String::trim)
                .toList();
    }
}
