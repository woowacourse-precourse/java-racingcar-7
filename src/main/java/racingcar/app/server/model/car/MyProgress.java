package racingcar.app.server.model.car;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.location.Position;
import racingcar.app.server.model.race.Lap;

public class MyProgress {

    private Lap remainingLap;
    private Distance currentDistance;

    private MyProgress(final Lap remainingLap, final Distance currentDistance) {
        this.remainingLap = remainingLap;
        this.currentDistance = currentDistance;
    }

    public static MyProgress from(final Lap remainingLap, final Distance currentDistance) {
        validateIsNull(remainingLap);
        validateIsNull(currentDistance);
        return new MyProgress(remainingLap, currentDistance);
    }

    public boolean completedAllLap() {
        return remainingLap.equals(Lap.ZERO);
    }


    public void updateDistance(Distance distance) {
        this.currentDistance = currentDistance.add(distance);
    }

    public void countDownRemainingLap(final Lap countDownAmount) {
        this.remainingLap = remainingLap.minus(countDownAmount);
    }

    public Position currentPosition() {
        return currentDistance.toPosition();
    }

    private static <T> void validateIsNull(T obj) {
        requireNonNull(obj, SHOULD_NOT_BE_NULL);
    }
}
