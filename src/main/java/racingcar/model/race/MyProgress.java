package racingcar.model.race;

public class MyProgress {
    private Lap remainingLap;
    private Position position;

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

    @Override
    public String toString() {
        return position.toString();
    }
}
