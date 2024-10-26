package racingcar.input;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class InputParser {

    private static final int NAME_LENGTH_MAX = 5;
    private static final String ONLY_NUMBER = "^[1-9]\\d*$";
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    public List<String> toList(final String input) {
        validateInputBlank(input);
        return Arrays.stream(split(input))
                .peek(this::validateToList)
                .toList();
    }

    public int toPositive(final String number) {
        validateInputBlank(number);
        validateNegative(number);
        return parseInteger(number);
    }

    private String[] split(final String input) {
        return input.split(COMMA);
    }

    private int parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.COUNT_ONLY_INTEGER_NUMBER_STRING);
        }
    }

    private void validateToList(final String input) {
        validateInputBlank(input);
        validateSpaceBetweenName(input);
        validateMaxNameSize(input);
    }

    private void validateMaxNameSize(final String input) {
        if (isMaxSize(input)) {
            throw new IllegalArgumentException(Constant.MAX_NAME_SIZE_STRING);
        }
    }

    private void validateSpaceBetweenName(final String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(Constant.SPACE_BETWEEN_NAME_STRING);
        }
    }

    private void validateNegative(final String number) {
        if (isNumber(number)) {
            throw new IllegalArgumentException(Constant.COUNT_ONLY_NATURAL_NUMBER_STRING);
        }
    }

    private void validateInputBlank(final String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(Constant.INPUT_NULL_OR_EMPTY_STRING);
        }
    }

    private boolean isBlank(final String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNumber(final String number) {
        return !number.matches(ONLY_NUMBER);
    }

    private boolean isSpace(final String input) {
        return input.contains(SPACE);
    }

    private boolean isMaxSize(final String input) {
        return input.length() > NAME_LENGTH_MAX;
    }
}
