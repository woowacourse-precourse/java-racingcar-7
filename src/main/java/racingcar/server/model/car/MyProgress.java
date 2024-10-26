package racingcar.server.model.car;

import static java.util.Objects.requireNonNull;
import static racingcar.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import racingcar.server.model.position.Distance;
import racingcar.server.model.position.Position;
import racingcar.server.model.race.Lap;

public class MyProgress {

    private Lap remainingLap;
    private Position position;

    // Constructor
    private MyProgress(final Lap remainingLap, final Position position) {
        this.remainingLap = remainingLap;
        this.position = position;
    }

    public static MyProgress from(final Lap remainingLap, final Position position) {
        validateIsNull(remainingLap);
        validateIsNull(position);
        return new MyProgress(remainingLap, position);
    }

    // Method
    public boolean completedAllLap() {
        return remainingLap.equals(Lap.ZERO);
    }


    public void updatePosition(Distance distance) {
        this.position = position.add(distance);
    }

    public void countDownRemainingLap(final Lap countDownAmount) {
        this.remainingLap = remainingLap.minus(countDownAmount);
    }

    @Override
    public String toString() {
        return position.toString();
    }

    // Validation
    private static <T> void validateIsNull(T obj) {
        requireNonNull(obj, SHOULD_NOT_BE_NULL);
    }
}
