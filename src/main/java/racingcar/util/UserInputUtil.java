package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputUtil {

    public static List<String> splitCarNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
