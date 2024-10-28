package racingcar.domain;

public record AttemptCount(int numberOfAttempts) {

    private static final int MIN_NUMBER_OF_ATTEMPTS = 1;

    public AttemptCount {
        validatePositiveNumber(numberOfAttempts);
    }

    private void validatePositiveNumber(int number) {
        if (number < MIN_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
