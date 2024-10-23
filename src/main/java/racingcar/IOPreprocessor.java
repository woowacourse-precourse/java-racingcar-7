package racingcar;

import java.util.Arrays;
import java.util.List;

public class IOPreprocessor {
    public static List<String> parsingInput(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
