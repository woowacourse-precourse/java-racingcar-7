package racingcar.domain.random;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class FixedRandomNumberGenerator implements RandomNumberGenerator {

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
        if(fixedValue < 0 || fixedValue > 10) {
            throw new BusinessException(RacingCarExceptionMessage.INVALID_NUMBER_EXCEPTION);
        }
    }
}
