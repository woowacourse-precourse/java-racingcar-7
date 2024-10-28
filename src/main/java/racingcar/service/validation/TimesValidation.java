package racingcar.service.validation;

import racingcar.exception.ErrorMessage;

public class TimesValidation {

    public static void validateAllInput(final String input){
        validateEmpty(input);
        validateNull(input);
        validateCharacter(input);
    }

    public static void validateEmpty(final String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_TIMES.toString());
        }
    }

    public static void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_TIMES.toString());
        }
    }
    public static void validateCharacter(final String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_DIGIT.toString());
        }
    }

    public static void validateZeroOrNegative(final int times) {
        if (times <= 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_POSITIVE.toString());
        }
    }

    private static boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

}

