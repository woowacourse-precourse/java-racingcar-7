package racingcar.domain;

import racingcar.exceptions.InvalidRoundValueException;

public class Round {

    private static final int INITIAL_ROUND = 0;
    private static final int MINIMUM_ROUND = 1;
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
            throw new InvalidRoundValueException("라운드 수는 1 이상이여야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
