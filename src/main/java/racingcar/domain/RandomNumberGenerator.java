package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.RacingCarException;
import racingcar.dto.MovementNumber;

public class RandomNumberGenerator {

    public MovementNumber movementNumber() {
        Integer randomNumber = randomNumber();
        validateNumber(randomNumber);
        return new MovementNumber(randomNumber);
    }

    private Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateNumber(Integer randomNumber) {
        validateNull(randomNumber);
        validateRange(randomNumber);
    }

    private void validateNull(Integer randomNumber) {
        if (randomNumber == null) {
            throw RacingCarException.from(RANDOM_NUMBER_REQUIRED);
        }
    }

    private void validateRange(Integer randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw RacingCarException.from(RANDOM_NUMBER_MUST_BE_IN_RANGE);
        }
    }
}
