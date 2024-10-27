package racingcar.domain;

public class Round {

    private static final int INITIAL_ROUND = 0;
    private static final int MINIMUM_ROUND = 1; // 최소 라운드 수
    private int round;

    public Round() {
        round = INITIAL_ROUND;
    }

    public void updateRound(int round) {
        this.round = round;
        validateInteger();
    }

    private void validateInteger() {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException();
        }
    }
    
    public int getRound() {
        return round;
    }
}
