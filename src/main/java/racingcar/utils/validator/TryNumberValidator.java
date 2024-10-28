package racingcar.utils.validator;


import racingcar.exception.RacingGameException.NotNumericException;
import racingcar.exception.RacingGameException.NotPositiveNumberException;
import racingcar.exception.RacingGameException.TryNumberEmptyInputException;

public class TryNumberValidator {

    public static void validateTryNumberIsCorrect(String tryNumber) {
        validateTryNumberIsEmpty(tryNumber);
        validateTryNumberIsNotInt(tryNumber);
        validateTryNumberIsPositiveNumber(tryNumber);
    }

    private static void validateTryNumberIsEmpty(String tryNumber) throws TryNumberEmptyInputException {
        if (tryNumber.isEmpty()) {
            throw new TryNumberEmptyInputException();
        }
    }

    private static void validateTryNumberIsNotInt(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new NotNumericException();
        }
    }

    private static void validateTryNumberIsPositiveNumber(String tryNumber) {
        int inputTryNumber = Integer.parseInt(tryNumber);
        if (notAllowNegativeAndZeroNumber(inputTryNumber)) {
            throw new NotPositiveNumberException();
        }
    }

    private static boolean notAllowNegativeAndZeroNumber(int tryNumber) {
        return tryNumber <= 0;
    }
}
