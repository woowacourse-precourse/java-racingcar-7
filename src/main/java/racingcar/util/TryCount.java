package racingcar.util;

public enum TryCount {

    MIN(1),
    MAX(100);

    private final int tryCount;

    TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
