package racingcar.domain;

public class Round {

    private int round;

    public Round() {
        round = 0;
    }

    public int getRound() {
        return round;
    }

    public void updateRound(int round) {
        this.round = round;
        validateInteger();
    }

    private void validateInteger() {
        if (round < 1) {
            throw new IllegalArgumentException("a");
        }
    }
}
