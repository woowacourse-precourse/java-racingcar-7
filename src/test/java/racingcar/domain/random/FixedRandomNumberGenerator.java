package racingcar.domain.random;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class FixedRandomNumberGenerator implements RandomNumberGenerator {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    private final Integer fixedValue;

    public FixedRandomNumberGenerator(Integer fixedValue) {
        validateValue(fixedValue);
        this.fixedValue = fixedValue;
    }

    @Override
    public Integer getRandomNumber(Integer min, Integer max) {
        return fixedValue;
    }

    private static void validateValue(Integer fixedValue) {
        if(fixedValue < MIN_VALUE || fixedValue > MAX_VALUE) {
            throw new BusinessException(RacingCarExceptionMessage.INVALID_NUMBER_EXCEPTION);
        }
    }
}
