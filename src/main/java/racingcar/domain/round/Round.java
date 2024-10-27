package racingcar.domain.round;

import racingcar.domain.common.IncrementNumber;

public class Round {

    private static final int MINIMUM_FINAL_ROUND = 1;

    private final IncrementNumber round;
    private final int finalRound;

    private Round(int finalRound) {
        this.round = new IncrementNumber();
        this.finalRound = finalRound;
    }

    public static Round from(int finalRound) {
        validateMinimumFinalRound(finalRound);
        return new Round(finalRound);
    }

    private static void validateMinimumFinalRound(int finalRound) {
        if (finalRound < MINIMUM_FINAL_ROUND) {
            throw new IllegalArgumentException();
        }
    }

    public void nextRound() {
        this.round.increment();
    }

    public int nowRound() {
        return this.round.getValue();
    }

    public boolean isNotFinalRound() {
        return !(this.nowRound() == finalRound);
    }

}
