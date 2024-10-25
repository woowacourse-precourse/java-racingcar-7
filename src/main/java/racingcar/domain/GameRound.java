package racingcar.domain;

import racingcar.validation.Validation;

public class GameRound {
    int roundCount;

    public GameRound(int roundCount) {
        Validation.validateRacingGameRoundCount(roundCount);
        this.roundCount = roundCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
