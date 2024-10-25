package racingcar.model.car;

import static java.util.Objects.isNull;
import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class MyProgress {
    private final Lap remainingLap;
    private final Position position;

    private MyProgress(final Lap remainingLap, final Position position) {
        validateIsNull(remainingLap);
        this.remainingLap = remainingLap;
        this.position = position;
    }

    public static MyProgress from(final Lap remainingLap, final Position position) {
        validateIsNull(remainingLap);
        return new MyProgress(remainingLap, position);
    }

    public boolean completedAllLap() {
        return remainingLap.equals(Lap.ZERO);
    }


    public void updatePosition(int moveCondition) {
        position.add(moveCondition);
    }

    public void updateRemainingLap() {
        remainingLap.minus(DEFAULT_LAP_COUNTING_POLICY);
    }

    private static void validateIsNull(Lap lap) {
        if (isNull(lap)) {
            throw new ShouldNotBeNullException();
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
