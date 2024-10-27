package racingcar.model;

public class GameTryCount {

    private static int tryCount;

    private GameTryCount() {}

    public static void set(int tryCount) {
        GameTryCount.tryCount = tryCount;
    }

    public static int get() {
        return tryCount;
    }
}
