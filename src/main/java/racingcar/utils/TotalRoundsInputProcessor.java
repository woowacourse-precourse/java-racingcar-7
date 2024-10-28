package racingcar.utils;

import static racingcar.exception.ExceptionMessage.*;

public class TotalRoundsInputProcessor {

    private TotalRoundsInputProcessor() {

    }

    public static int parseTotalRounds(String roundInput) {
        validInput(roundInput);
        return parseCount(roundInput);
    }

    static void validInput(String roundInput) {
        if (roundInput == null || roundInput.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ROUNDS_ERROR);
        }
    }

    static int parseCount(String roundInput) {
        try {
            int totalRounds = Integer.parseInt(roundInput);
            if (totalRounds <= 0) {
                throw new IllegalArgumentException(NON_POSITIVE_ROUNDS_ERROR);
            }
            return totalRounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }
}
