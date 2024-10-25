package racingcar.model.car;

import static java.util.Objects.isNull;
import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.position.Distance;
import racingcar.model.position.Position;
import racingcar.model.race.Lap;

public class MyProgress {
    private Lap remainingLap;
    private Position position;

    private MyProgress(final Lap remainingLap, final Position position) {
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


    public void updatePosition(Distance distance) {
        this.position = position.add(distance);
    }

    public void updateRemainingLap() {
        this.remainingLap = remainingLap.minus(DEFAULT_LAP_COUNTING_POLICY);
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
