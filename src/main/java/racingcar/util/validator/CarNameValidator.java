package racingcar.util.validator;

import static racingcar.util.validator.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.validator.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_NOT_NULL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNameValidator {
    private static final int MAX_DIGIT_CAR_NAME = 5;
    private static final int MIN_DIGIT_CAR_NAME = 1;

    public static void checkDuplicate(List<String> input) {
        if (hasDuplicateCarName(input)) {
            throw new IllegalArgumentException(INPUT_STRING_DUPLICATE.message);
        }
    }

    public static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_STRING_NOT_NULL.message);
        }
    }

    public static void checkEmpty(List<String> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_STRING_NOT_NULL.message);
        }
    }
    public static void checkOverRange(String input) {
        if (isOverRange(input) || isUnderRange(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_IS_INCORRECT.message);
        }
    }

    public static void checkSpace(String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_BLANK.message);
        }
    }

    private static boolean hasDuplicateCarName(List<String> input) {
        Set set = new HashSet(input);

        return input.size() != set.size();
    }

    private static boolean isOverRange(String input) {
        return MAX_DIGIT_CAR_NAME < input.length();
    }

    private static boolean isUnderRange(String input) {
        return MIN_DIGIT_CAR_NAME > input.length();
    }

    private static boolean isSpace(String input) {
        return Pattern.matches("^\\s+$", input);
    }
}

