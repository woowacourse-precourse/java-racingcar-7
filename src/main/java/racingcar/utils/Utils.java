package racingcar.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> splitNames(String input) {
        return Arrays.stream(input.split(","))
                .map(Utils::removeWhitespace)
                .filter(Utils::validateName)
                .collect(Collectors.toList());
    }
}
