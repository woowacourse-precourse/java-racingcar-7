package racingcar.model.car;

import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class MyProgress {
    private final Lap remainingLap;
    private final Position position;

    private MyProgress(final Lap remainingLap, final Position position) {
        this.remainingLap = remainingLap;
        this.position = position;
    }

    public static MyProgress from(final Lap remainingLap, final Position position) {
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

    @Override
    public String toString() {
        return position.toString();
    }
}
