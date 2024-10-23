package racingcar.utils;

import java.util.Arrays;
import java.util.List;

import static racingcar.constants.Config.NAME_DELIMITER;

public class CarNameParser {
    public static List<String> parse(String carNames) {
        return Arrays.stream(carNames.split(NAME_DELIMITER))
                .toList();
    }
}
