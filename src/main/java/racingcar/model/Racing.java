package racingcar.model;

public class Racing {
    private final int END_GAME_COUNT = 0;
    private int tryCount;

    public void saveTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void minusTryCount() {
        this.tryCount--;
    }

    public boolean isProgress(){
        return this.tryCount > END_GAME_COUNT;
    }
}
