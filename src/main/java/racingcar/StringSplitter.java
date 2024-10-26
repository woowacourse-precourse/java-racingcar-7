package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
