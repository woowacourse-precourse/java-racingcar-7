package racingcar.exception;

import racingcar.enums.ErrorMessages;

public class InputValidator {
    private static final String WHITE_SPACES_REGEX = "^\\s*$";
    private static final String DIGIT_REGEX = "^[0-9]*$";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_REPEAT_TIMES = 0;

    private static InputValidator instance;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    public void validateWhiteSpaces(String carsNames, String repeatTimes) {
        if (carsNames.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_WHITESPACES.getMsg());
        }

        if (repeatTimes.matches(WHITE_SPACES_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_WHITESPACES.getMsg());
        }
    }

    public void validateInvalidCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH_OUT_OF_BOUND.getMsg());
        }
    }

    public void validateRepeatTimesNotDigit(String repeatTimes) {
        if (!repeatTimes.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.REPEAT_TIMES_NOT_DIGIT.getMsg());
        }
    }

    public void validateOutOfRangeRepeatTimes(String repeatTimes) {
        int convertedRepeatTimes;

        try {
            convertedRepeatTimes = Integer.parseInt(repeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.REPEAT_TIMES_OUT_OF_BOUND.getMsg());
        }

        if (convertedRepeatTimes < MIN_REPEAT_TIMES) {
            throw new IllegalArgumentException(ErrorMessages.REPEAT_TIMES_OUT_OF_BOUND.getMsg());
        }
    }
}
