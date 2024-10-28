package racingcar.validation;

import racingcar.exception.RaceCountsErrorMessage;
import racingcar.exception.RaceCountsException;

public class RaceCountsValidation {
    private static final int MIN_RACE_COUNT = 1;  // 최소 경기 횟수

    public static int validateRaceCounts(String raceCounts) {
        isRaceCountsEmpty(raceCounts);
        int count = parseRaceCounts(raceCounts);
        isPositive(count);
        return count;
    }

    private static void isRaceCountsEmpty(String raceCounts) {
        if (raceCounts.isBlank()) throw new RaceCountsException(RaceCountsErrorMessage.COUNT_EMPTY);
    }

    private static int parseRaceCounts(String raceCounts) {
        try {
            return Integer.parseInt(raceCounts);
        } catch (NumberFormatException e) {
            throw new RaceCountsException(RaceCountsErrorMessage.COUNT_NOT_INTEGER);
        }
    }

    private static void isPositive(int raceCounts) {
        if (raceCounts < MIN_RACE_COUNT) throw new RaceCountsException(RaceCountsErrorMessage.COUNT_NEGATIVE);
    }
}

