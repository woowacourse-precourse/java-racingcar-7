package racingcar;

import java.util.List;

public class Parser {
    private static final String CAR_NAME_DELIMITER = ",";
    public static List<String> parserCarName(final String carName) {
        return List.of(carName.split(CAR_NAME_DELIMITER));
    }
}
