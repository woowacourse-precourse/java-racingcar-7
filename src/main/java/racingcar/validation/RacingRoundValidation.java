package racingcar.validation;

public class RacingRoundValidation {
    private static final Integer ROUND_CRITERION_NUMBER = 1;
    private static final String INTEGER_CONTAIN_VALUE = "^[0-9]+$";

    public static boolean validateRacingRoundType(String racingRound) {
        return !racingRound.matches(INTEGER_CONTAIN_VALUE);
    }

    public static boolean validateRacingRoundNumberRange(Integer racingRound) {
        return racingRound < ROUND_CRITERION_NUMBER;
    }
}
