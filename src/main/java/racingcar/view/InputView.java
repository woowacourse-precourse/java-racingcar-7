package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionMessage;

public class InputView {
    private static final String DIGIT_PATTERN = "\\d+";

    public String getString() {
        String input = Console.readLine();
        validateEmptyString(input);

        return input;
    }

    private void validateEmptyString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY_STRING.getMessage());
        }
    }

    public int getPositiveInteger() {
        String input = getString();
        validateDigitFormat(input);
        validatePositiveIntegerRange(input);

        return Integer.parseInt(input);
    }

    private void validateDigitFormat(String input) {
        if (!input.matches(DIGIT_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_DIGIT_CHARACTER.getMessage());
        }
    }

    private void validatePositiveIntegerRange(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value == 0) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_INVALID_POSITIVE_INTEGER_RANGE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_INVALID_POSITIVE_INTEGER_RANGE.getMessage());
        }
    }
}
