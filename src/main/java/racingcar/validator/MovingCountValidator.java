package racingcar.validator;

import java.math.BigInteger;
import racingcar.exception.RacingException;
import racingcar.view.ErrorMessage;

public class MovingCountValidator {

    public Long validateMovingCount(String rawMovingCount) {
        if (rawMovingCount == null || rawMovingCount.isBlank()) {
            throw RacingException.from(ErrorMessage.NO_INPUT);
        }

        rawMovingCount = rawMovingCount.stripLeading().stripTrailing();

        try {
            long movingCount = Long.parseLong(rawMovingCount);

            if (movingCount < 0L) {
                throw RacingException.from(ErrorMessage.NEGATIVE_MOVING_COUNT);
            }

            return movingCount;
        } catch (NumberFormatException e) {
            if (rawMovingCount.contains(".")) {
                throw RacingException.from(ErrorMessage.DECIMAL_MOVING_COUNT);
            }

            return validateBigIntegerConversion(rawMovingCount);
        }
    }

    private static Long validateBigIntegerConversion(String numberString) {
        try {
            BigInteger bigIntegerValue = new BigInteger(numberString);
            throw new RacingException(ErrorMessage.TOO_MANY_MOVING_COUNT);
        } catch (NumberFormatException e) {
            throw RacingException.from(ErrorMessage.INVALID_MOVING_COUNT);
        }
    }
}
