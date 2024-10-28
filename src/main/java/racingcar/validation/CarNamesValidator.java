package racingcar.validation;

import racingcar.view.constant.ExceptionConstant;

public class CarNamesValidator {
    public static final int NAME_LENGTH_LIMIT = 5;
    public static final String BLANK = " ";
    public static final String ALPHABET_AND_NUMBERS = "^[a-zA-Z0-9]*$";

    private static boolean isLengthValid(String name) {
        return name.length() <= NAME_LENGTH_LIMIT && !name.isEmpty();
    }

    private static boolean isContainBlank(String name) {
        return name.contains(BLANK);
    }

    private static boolean hasOtherDelimiter(String name) {
        return !name.matches(ALPHABET_AND_NUMBERS);
    }

    public void validateCarNames(String name) {
        if (isContainBlank(name))
            throw new IllegalArgumentException(ExceptionConstant.NOT_ALLOWED_BLANK);
        if (hasOtherDelimiter(name))
            throw new IllegalArgumentException(ExceptionConstant.NOT_ALLOWED_OTHER_DELIMITERS);
        if (!isLengthValid(name))
            throw new IllegalArgumentException(ExceptionConstant.NOT_VALID_LENGTH);
    }
}