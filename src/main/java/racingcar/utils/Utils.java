package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static String removeWhitespace(String name) {
        return name.replaceAll("\\s+", ""); // "정규표현식" \\s: 모든 공백 문자, +: 앞의 패턴 반복됨
    }

    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(","))
                .map(Utils::removeWhitespace)
                .filter(Utils::validateName)
                .collect(Collectors.toList());
    }
}
