package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class MoveCount {
    private static final int MAX_MOVE_COUNT = Integer.MAX_VALUE;
    private int value;

    public MoveCount(String input) {
        validateInput(input);
        this.value = parseAndValidateNumber(input);
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }

    private int parseAndValidateNumber(String input) {
        int number = convertToNumber(input.trim());
        validateRange(number);
        return number;
    }

    private int convertToNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_NUMBER_FORMAT);
        }
        return Integer.parseInt(input);
    }

    private void validateRange(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_MOVE_COUNT);
        }
        if (number > MAX_MOVE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NUMBER_TOO_LARGE);
        }
    }

    public int getValue() {
        return value;
    }
}