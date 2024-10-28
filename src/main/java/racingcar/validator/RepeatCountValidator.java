package racingcar.validator;

import static racingcar.validator.ErrorCode.REPEAT_COUNT_EXCEEDS_INT_MAX;
import static racingcar.validator.ErrorCode.REPEAT_COUNT_MUST_BE_INTEGER;
import static racingcar.validator.ErrorCode.REPEAT_COUNT_MUST_BE_POSITIVE;

import java.math.BigInteger;

public class RepeatCountValidator {

    public static void validate(String repeatCountStr) {
        int repeatCount = checkIntegerFormat(repeatCountStr);
        checkPositive(repeatCount);
    }

    private static int checkIntegerFormat(String repeatCountStr) {
        try {
            BigInteger parsedValue = new BigInteger(repeatCountStr);
            return checkIntMaxValue(parsedValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REPEAT_COUNT_MUST_BE_INTEGER.getMessage());
        }
    }

    private static int checkIntMaxValue(BigInteger bigIntValue) {
        if (bigIntValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(REPEAT_COUNT_EXCEEDS_INT_MAX.getMessage());
        }
        return bigIntValue.intValue();
    }

    private static void checkPositive(int repeatCount) {
        if (repeatCount <= 0) {
            throw new IllegalArgumentException(REPEAT_COUNT_MUST_BE_POSITIVE.getMessage());
        }
    }
}
