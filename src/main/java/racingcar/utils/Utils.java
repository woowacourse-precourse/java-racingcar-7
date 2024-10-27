package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorCode;

public class Utils {
    public static String removeWhitespace(String name) {
        validateName(name);

        return name.replaceAll("\\s+", ""); // "정규표현식" \\s: 모든 공백 문자, +: 앞의 패턴 반복됨
    }

    public static void validateName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException(ErrorCode.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(","))
                .map(Utils::removeWhitespace)
                .collect(Collectors.toList());
    }
}
