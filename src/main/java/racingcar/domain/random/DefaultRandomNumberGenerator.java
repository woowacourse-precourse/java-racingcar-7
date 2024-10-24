package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public Integer getRandomNumber(Integer min, Integer max) {
        validateNumberRange(min, max);
        return Randoms.pickNumberInRange(min,max);
    }

    private static void validateNumberRange(Integer min, Integer max) {
        if (min < 0 || max > 9){
            throw new BusinessException(RacingCarExceptionMessage.INVALID_NUMBER_EXCEPTION);
        }
    }
}
