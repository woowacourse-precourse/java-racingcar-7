package racingcar.domain;

public class RoundNumber {
    private int roundNumber;

    public RoundNumber(int roundNumber) {
        checkMinimumValue(roundNumber);
        this.roundNumber = roundNumber;
    }

    private void checkMinimumValue(int roundNumber) {
        if (roundNumber < 0) {
            throw new IllegalArgumentException();
        }
    }
}