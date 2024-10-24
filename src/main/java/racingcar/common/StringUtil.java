package racingcar.common;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String DELIMITER = ",";

    public static List<String> splitByComma(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .peek(NameValidator::isValidSize)
                .peek(NameValidator::isNotBlank)
                .toList();
    }

    public static Long parseToNumeric(String secondLine) {
        try {
            return Long.parseLong(secondLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid number format : " + secondLine);
        }
    }
}
