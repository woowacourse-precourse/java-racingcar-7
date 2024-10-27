package racingcar.validation;

import racingcar.exception.RaceCountsException;

public class RaceCountsValidation {

    public static int validateRaceCounts(String raceCounts) {
        isRaceCountsEmpty(raceCounts);
        int count = parseRaceCounts(raceCounts);
        isPositive(count);
        return count;
    }

    private static void isRaceCountsEmpty(String raceCounts) {
        if (raceCounts.isBlank()) throw new RaceCountsException(RaceCountsException.MESSAGE_COUNT_EMPTY);
    }

    private static int parseRaceCounts(String raceCounts) {
        try {
            return Integer.parseInt(raceCounts);
        } catch (NumberFormatException e) {
            throw new RaceCountsException(RaceCountsException.MESSAGE_COUNT_NOT_INTEGER);
        }
    }

    private static void isPositive(int raceCounts) {
        if (raceCounts < 1) throw new RaceCountsException(RaceCountsException.MESSAGE_COUNT_NEGATIVE);
    }
}


