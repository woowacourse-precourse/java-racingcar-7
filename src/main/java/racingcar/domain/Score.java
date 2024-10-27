package racingcar.domain;

public class Score {
    private final int INITIAL_VALUE = 0;
    private final int FIXED_MOVE_POINT = 1;

    private int score;

    public Score() {
        this.score = INITIAL_VALUE;
    }

    public void moveForward() {
        this.score += FIXED_MOVE_POINT;
    }

    public int getScore() {
        return this.score;
    }
}
