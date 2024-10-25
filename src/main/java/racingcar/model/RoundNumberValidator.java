package racingcar.model;

public class RoundNumberValidator {

    public void validateRoundNumber(int roundNumber) {
        if (roundNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
