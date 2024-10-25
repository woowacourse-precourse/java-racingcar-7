package racingcar.model.race;

import static java.util.Objects.isNull;
import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.race.exception.ShouldNotBeMinusException;

public class Race {

    private Lap remainingCount;

    private Race(final Lap remainingCount) {
        this.remainingCount = remainingCount;
    }

    public static Race from(final Lap lap) {
        validateIsNull(lap);
        return new Race(lap);
    }

    public boolean isUnderway() {
        return remainingCount.hasRemaining();
    }

    public void moveToNextLap() {
        if (remainingCount.isZero()) {
            throw new ShouldNotBeMinusException();
        }
        this.remainingCount = remainingCount.minus(DEFAULT_LAP_COUNTING_POLICY);
    }

    private static void validateIsNull(final Lap lap) {
        if (isNull(lap)) {
            throw new ShouldNotBeNullException();
        }
    }
}
