package racingcar.domain;

import static racingcar.common.exception.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.exception.RacingCarException;
import racingcar.dto.MovementValue;

public class RandomValueGenerator {

    public MovementValue generateMovementValue() {
        Integer value = generateRandomValue();
        validateValue(value);
        return new MovementValue(value);
    }

    private Integer generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateValue(Integer value) {
        validateNull(value);
        validateRange(value);
    }

    private void validateNull(Integer value) {
        if (value == null) {
            throw RacingCarException.from(RANDOM_VALUE_GENERATOR_NULL_VALUE);
        }
    }

    private void validateRange(Integer value) {
        if (value < 0 || value > 9) {
            throw RacingCarException.from(RANDOM_VALUE_GENERATOR_OUT_OF_RANGE);
        }
    }
}
