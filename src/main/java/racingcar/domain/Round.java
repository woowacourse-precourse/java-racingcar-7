package racingcar.domain;

public class Round {

    private final int round;

    public Round(int round) {
        this.round = round;
        validateInteger();

    }

    public int getRound() {
        return round;
    }

    private void validateInteger() {
        if (round < 1) {
            throw new IllegalArgumentException("a");
        }
    }
}
