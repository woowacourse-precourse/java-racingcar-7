package racingcar;

public class Track {

    private int lap;

    public Track(int lap) {
        this.lap = lap;
    }

    public boolean isLapInProgress() {
        return lap > 0;
    }
}
