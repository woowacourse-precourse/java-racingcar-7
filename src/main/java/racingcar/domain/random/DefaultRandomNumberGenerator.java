package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    private final static Integer MIN_VALUE = 0;
    private final static Integer MAX_VALUE = 9;

    @Override
    public Integer getRandomNumber(Integer min, Integer max) {
        validateNumberRange(min, max);
        return Randoms.pickNumberInRange(min, max);
    }

    private static void validateNumberRange(Integer min, Integer max) {
        if (min < MIN_VALUE || max > MAX_VALUE) {
            throw new BusinessException(RacingCarExceptionMessage.INVALID_NUMBER_EXCEPTION);
        }
    }
}
