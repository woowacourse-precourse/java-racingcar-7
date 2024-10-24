package racingcar.common;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String DELIMITER = ",";

    public static List<String> splitByComma(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .peek(NameValidator::isValidSize)
                .peek(NameValidator::isNotBlank)
                .toList();
    }
}
