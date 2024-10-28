package racingcar.utils;

public class CarRacingValidator implements Validator {
    private static final String TOTAL_RACE_EMPTY_INPUT = ERROR_PREFIX + "입력값이 비어있습니다.";
    private static final String TOTAL_RACE_NOT_CHAR = ERROR_PREFIX + "입력값은 숫자여야 합니다.";
    private static final String TOTAL_RACE_GREATER_THAN_ZERO = ERROR_PREFIX + "입력값은 0보다 커야합니다.";

    @Override
    public void validation(String totalRacingCounter) {
        checkEmptyRaceInput(totalRacingCounter);
        checkTotalRaceInvalidInput(totalRacingCounter);
    }

    private void checkEmptyRaceInput(String totalRacingCounter) {
        if (totalRacingCounter == null || totalRacingCounter.trim().isEmpty()) {
            throw new IllegalArgumentException(TOTAL_RACE_EMPTY_INPUT);
        }
    }

    private void checkTotalRaceInvalidInput(String totalRacingCounter) {
        try {
            int totalRacingValue = Integer.parseInt(totalRacingCounter);
            if (totalRacingValue <= 0) {
                throw new IllegalArgumentException(TOTAL_RACE_GREATER_THAN_ZERO);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TOTAL_RACE_NOT_CHAR);
        }
    }
}
