package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorCode;

public class Utils {
    public static String removeWhitespace(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(","))
                .map(Utils::removeWhitespace)
                .peek(Utils::validateName) // .peek은 최종 연산이 있는 경우에만 동작한다.
                .collect(Collectors.toList());
    }

    public static int inputToInt(String input) {
        try {
            int number = Integer.parseInt(Utils.removeWhitespace(input));
            if (number < 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER.getMessage());
        }
    }
}
