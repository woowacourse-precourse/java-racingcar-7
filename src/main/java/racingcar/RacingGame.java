package racingcar;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        validateTryCount();
        this.cars = cars;
        this.tryCount = tryCount;
    }

    private void validateTryCount() {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }
}
