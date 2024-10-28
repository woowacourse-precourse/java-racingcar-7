package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> splitCarNames(String carNamesInput) {
        String[] namesArray = carNamesInput.split(NAME_DELIMITER);
        List<String> names = new ArrayList<>();

        for (String name : namesArray) {
            String seperatedName = name.trim();
            validateCarName(seperatedName);
            names.add(seperatedName);
        }

        if (names.isEmpty()) {
            throw new IllegalArgumentException("[error] 자동차 이름을 입력하세요");
        }
        return names;
    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[error] 자동차 이름은 1~5자");
        }

    }
}
