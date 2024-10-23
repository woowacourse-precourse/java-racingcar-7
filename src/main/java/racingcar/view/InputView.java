package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern VALID_CAR_INPUT_PATTERN = Pattern.compile("[a-zA-Z]{1,4}(,[a-zA-z]{1,4})*");
    private static final Pattern VALID_MOVE_COUNT_INPUT_PATTERN = Pattern.compile("^(0|[1-9][0-9]*)$");

    public static String readLine() {
        return Console.readLine();
    }

    public static String[] splitCarNamesByComma(String input) {
        return input.split(",");
    }

    public static boolean isValidCarInput(String input) {
        return VALID_CAR_INPUT_PATTERN.matcher(input).matches();
    }

    public static boolean isValidMoveCountInput(String input) {
        return VALID_MOVE_COUNT_INPUT_PATTERN.matcher(input).matches();
    }

}
