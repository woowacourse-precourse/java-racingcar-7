package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private static final String NAME_DELIMITER = ",";

    public static List<String> parse(String carNames) {
        return Arrays.stream(carNames.split(NAME_DELIMITER))
                .peek(CarNameParser::validateName)
                .toList();
    }

    private static void validateName(String name) {
        if (!isValidLength(name)) throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이내여야 합니다.");
    }

    private static boolean isValidLength(String name) {
        return name.length() <= 5;
    }
}
