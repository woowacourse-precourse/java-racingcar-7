package racingcar.common.util;

import static racingcar.common.constant.Constant.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<String> splitStringToList(String input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
