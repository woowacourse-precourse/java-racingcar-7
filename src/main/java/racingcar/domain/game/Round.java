package racingcar.domain.game;

import static racingcar.constant.GameConstants.INITIAL_ROUND;

public class Round {
    private final TotalRounds totalRounds;
    private final int currentRound;

    private Round(TotalRounds totalRounds, int currentRound) {
        this.totalRounds = totalRounds;
        this.currentRound = currentRound;
    }

    public static Round of(int totalRounds) {
        return new Round(
                TotalRounds.of(totalRounds),
                INITIAL_ROUND
        );
    }


}
