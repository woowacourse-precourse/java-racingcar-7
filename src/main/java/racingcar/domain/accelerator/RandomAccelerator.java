package racingcar.domain.accelerator;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class RandomAccelerator implements Accelerator {

    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;
    private final static int MOVABLE_VALUE = 4;

    @Override
    public boolean isMovable(Integer randomNumber) {
        validateNumber(randomNumber);

        return randomNumber >= MOVABLE_VALUE;
    }

    private void validateNumber(Integer randomNumber) {
        if (isNull(randomNumber)) {
            throw new BusinessException(RacingCarExceptionMessage.INVALID_NUMBER_EXCEPTION);
        }

        if (isOutOfRange(randomNumber)) {
            throw new BusinessException(RacingCarExceptionMessage.NUMBER_IS_NOT_NULL);
        }
    }

    private boolean isOutOfRange(Integer randomNumber) {
        return randomNumber < MIN_VALUE || randomNumber > MAX_VALUE;
    }

    private boolean isNull(Integer randomNumber) {
        return randomNumber == null;
    }
}
