package racingcar.validation;

public class RoundNumberValidator {

    private static final int ROUND_NUMBER_STANDARD = 1;

    public void validateRoundNumber(int roundNumber) {
        if (roundNumber < ROUND_NUMBER_STANDARD) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
