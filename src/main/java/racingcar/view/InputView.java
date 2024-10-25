package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int SPLIT_INCLUDE_LAST_SPACE = -1;

    public static List<String> carNames() {
        return splitNames(input());
    }

    public static List<String> splitNames(String input) {
        List<String> splitNames = Arrays.stream(input.split(DELIMITER, SPLIT_INCLUDE_LAST_SPACE)).toList();
        validateNames(splitNames);
        return splitNames;
    }

    private static void validateNames(List<String> splitNames) {
        if (splitNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException();
        }
    }

    public static int tryCount() {
        return convertToInt(input());
    }

    public static int convertToInt(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
