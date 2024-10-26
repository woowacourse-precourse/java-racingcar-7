package racingcar.model;

public class AttemptCount {
    private static final String ERROR_ATTEMPT_COUNT_DEPLETED = "시도 횟수가 부족합니다. 더 이상 감소할 수 없습니다.";
    private static final String ERROR_NEGATIVE_OR_ZERO_COUNT = "시도 횟수는 0 이상이어야 합니다.";
    private static final int MIN_ATTEMPT_COUNT = 1;

    private int count;

    private AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        validateCountRange(count);
        return new AttemptCount(count);
    }

    private static void validateCountRange(int count) {
        if (count < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_OR_ZERO_COUNT);
        }
    }

    public void decrease() {
        checkRemainingAttempts();
        count--;
    }

    private void checkRemainingAttempts(){
        if(count < MIN_ATTEMPT_COUNT){
            throw new IllegalArgumentException(ERROR_ATTEMPT_COUNT_DEPLETED);
        }
    }

    public boolean canRace() {
        return count >= MIN_ATTEMPT_COUNT;
    }
}
