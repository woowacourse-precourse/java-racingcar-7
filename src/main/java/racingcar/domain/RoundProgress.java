package racingcar.domain;

import static racingcar.constant.ExceptionMessage.NO_MORE_ROUNDS;

import racingcar.vo.Round;

public class RoundProgress {
    private final Round totalRounds;
    private Round currentRound;

    private RoundProgress(Round totalRounds, Round currentRound) {
        this.totalRounds = totalRounds;
        this.currentRound = currentRound;
    }

    public static RoundProgress createFromTotalRounds(Round totalRounds) {
        return new RoundProgress(totalRounds, Round.from(1));
    }

    public boolean hasNext() {
        return currentRound.getCount() <= totalRounds.getCount();
    }

    public void progress() {
        if (!hasNext()) {
            throw new IllegalStateException(NO_MORE_ROUNDS.message());
        }

        currentRound = currentRound.next();
    }
}
