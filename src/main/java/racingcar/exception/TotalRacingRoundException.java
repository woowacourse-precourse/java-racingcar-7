package racingcar.exception;

import racingcar.validation.RacingRoundValidation;

public class TotalRacingRoundException {
    public static void racingRoundTypeException(String totalRacingRound) {
        if (RacingRoundValidation.validateRacingRoundType(totalRacingRound)) {
            throw new RoundTypeException();
        }
    }

    public static void racingRoundNumberRangeException(Integer racingRound) {
        if (RacingRoundValidation.validateRacingRoundNumberRange(racingRound)) {
            throw new RoundNumberRangeException();
        }
    }
}
