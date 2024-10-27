package racingcar.exception;

import racingcar.validation.RacingRoundValidation;

public class TotalRacingRoundException {
    public static void racingRoundNumberRangeException(Integer racingRound) {
        if (RacingRoundValidation.validateRacingRoundNumberRange(racingRound)) {
            throw new RoundNumberRangeException();
        }
    }

    public static Integer changeRoundTypeException(String totalRacingRound) {
        try {
            return Integer.parseInt(totalRacingRound);
        } catch (NumberFormatException e) {
            throw new RoundTypeException();
        }
    }
}
