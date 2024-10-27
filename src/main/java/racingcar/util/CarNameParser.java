package racingcar.util;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.DomainConstants.CAR_NAME_DEFAULT_DELIMITER;

public class CarNameParser {
    public static List<String> parse(String input) {
        return Arrays.asList(input.split(CAR_NAME_DEFAULT_DELIMITER));
    }
}
