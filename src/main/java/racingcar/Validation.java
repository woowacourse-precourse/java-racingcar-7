package racingcar;

import static racingcar.Constant.DUPLICATE_MESSAGE;
import static racingcar.Constant.EMPTY_MESSAGE;
import static racingcar.Constant.END_DELIMITER_MESSAGE;
import static racingcar.Constant.LENGTH_OVER_MESSAGE;
import static racingcar.Constant.MIN_MOVES_MESSAGE;
import static racingcar.Constant.TOO_MANY_CARS_MESSAGE;
import static racingcar.Constant.TOO_MANY_MOVES_MESSAGE;

import java.util.List;

public class Validation {
    private static final String DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_CARS = 10;
    private static final int MAX_MOVES = 10;
    private static final int MIN_MOVES = 1;

    public static String inputValidate(String string) {
        string = string.trim();
        if (string.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        return string;
    }

    public static void inputLastIndexValidate(String string) {
        if (string.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(END_DELIMITER_MESSAGE);
        }
    }

    public static void nameLengthValidate(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_OVER_MESSAGE);
        }
    }

    public static void nameDuplicateValidate(String string, List<String> list) {
        if (list.contains(string)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public static void tooManyCarsValidate(List<String> list) {
        if (list.size() > MAX_CARS) {
            throw new IllegalArgumentException(TOO_MANY_CARS_MESSAGE);
        }
    }

    public static void tooManyMovesValidate(int move) {
        if (move > MAX_MOVES) {
            throw new IllegalArgumentException(TOO_MANY_MOVES_MESSAGE);
        }
    }

    public static void moveValidate(int move) {
        if (move < MIN_MOVES) {
            throw new IllegalArgumentException(MIN_MOVES_MESSAGE);
        }
    }

}
