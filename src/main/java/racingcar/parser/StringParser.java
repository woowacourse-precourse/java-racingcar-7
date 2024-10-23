package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<String> parseCarName(String carString) {
        return Arrays.stream(carString.split(","))
                .collect(Collectors.toList());
    }
}
