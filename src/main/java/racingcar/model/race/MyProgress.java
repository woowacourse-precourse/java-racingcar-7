package racingcar.model.race;

import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

public class MyProgress {
    private final Lap remainingLap;
    private final Position position;

    private MyProgress(final Lap remainingLap, final Position position) {
        this.remainingLap = remainingLap;
        this.position = position;
    }

    public static MyProgress initiate(final Lap remainingLap, final Position position) {
        return new MyProgress(remainingLap, position);
    }

    public boolean completedAllLap() {
        return remainingLap.equals(Lap.ZERO);
    }


    public void updatePositionBy(final int moveDistance) {
        position.add(moveDistance);
    }

    public void updateRemainingLap() {
        remainingLap.minus(DEFAULT_LAP_COUNTING_POLICY);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
