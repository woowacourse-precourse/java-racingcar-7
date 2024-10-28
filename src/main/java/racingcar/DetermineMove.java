package racingcar;

public class DetermineMove {
    private static final int MOVE_THRESHOLD = 4;

    public boolean shouldMove(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
