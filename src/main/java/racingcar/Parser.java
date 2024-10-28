package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {

    }

    public static List<String> trimSplit(final String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.replaceAll(String::trim);

        return carNames;
    }
}
