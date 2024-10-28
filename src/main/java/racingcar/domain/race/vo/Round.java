package racingcar.domain.race.vo;

import static racingcar.domain.race.constants.RaceCriterion.*;
import static racingcar.infrastructure.exception.ErrorCode.*;


public record Round(int round) {

    public Round {
        if (round < NOT_NEGATIVE_LIMIT.getCriterion()) {
            throw new IllegalArgumentException(ROUND_LESS_THAN_ONE.getMessage());
        }
    }

    public Round nextRound() {
        if (round == RACE_END.getCriterion()) {
            return this;
        }

        return new Round(round - ROUND_DECREMENT.getCriterion());
    }

    public boolean hasMoreRounds() {
        return round > RACE_END.getCriterion();
    }
}
