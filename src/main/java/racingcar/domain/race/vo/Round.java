package racingcar.domain.race.vo;

import static racingcar.domain.race.constants.RaceCriterion.*;
import static racingcar.infrastructure.exception.ErrorCode.*;


public record Round(int round) {

    public Round {
        if (round < NOT_NEGATIVE.getCriterion()) {
            throw new IllegalArgumentException(ROUND_LESS_THAN_ONE.getMessage());
        }
    }

    public Round nextRound() {
        if (round == END_RACE.getCriterion()) {
            return this;
        }

        return new Round(round - ROUND_DECREASE.getCriterion());
    }

    public boolean hasMoreRounds() {
        return round > END_RACE.getCriterion();
    }
}
