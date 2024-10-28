package racingcar.utils;

import static racingcar.view.InputView.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> getNames(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int getRepeatCount(String input) {
        return Integer.parseInt(input);
    }
}
