package racingcar.model;

public class GameTryCount {

    private static int tryCount;

    public GameTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public static int get() {
        return tryCount;
    }
}
