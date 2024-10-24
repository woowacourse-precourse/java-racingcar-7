package racingcar;

public abstract class Validation {

    private static final int MOVE_STANDARD = 4;

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
        }
    }

    public static int validateAttemptCount(String attemptCount) {
        int count = Integer.parseInt(attemptCount);
        if (MoveCondition.getCondition() > MOVE_STANDARD) {
            return count;
        }
        return 0;
    }
}