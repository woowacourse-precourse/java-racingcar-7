package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {

    public static List<String> processCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public static int processAttemptCount(String input) {
        return Integer.parseInt(input);
    }
}
