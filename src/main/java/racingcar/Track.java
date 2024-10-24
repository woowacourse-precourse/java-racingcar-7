package racingcar;

public class Track {

    private int lap;

    public Track(int lap) {
        this.lap = lap;
    }

    public static Track from(int lap) {
        validateLapRange(lap);
        return new Track(lap);
    }

    private static void validateLapRange(int lap) {
        int minLap = 1;
        if (lap < minLap) {
            throw new IllegalArgumentException("최소 1회 이상 횟수를 입력해주세요.");
        }
    }

    public boolean isLapInProgress() {
        return lap > 0;
    }

    public void decrementLap() {
        lap -= 1;
    }
}
