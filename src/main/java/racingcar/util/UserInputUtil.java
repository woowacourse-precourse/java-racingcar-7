package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputUtil {
    // 굳이 뺼 필요가 있을까? 걍 콤마써도 될꺼같은데
    private static final String DELIMITER = ",";

    public static List<String> splitNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
