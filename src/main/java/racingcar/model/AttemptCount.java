package racingcar.model;

public class AttemptCount {

    public static final int MIN_ATTEMPT_COUNT = 1;
    public static final int MAX_ATTEMPT_COUNT = 10;

    private final int racingAttemptCount;

    public AttemptCount(int count) {
        this.racingAttemptCount = count;
        validateValidCount();
    }

    public static AttemptCount fromString(String count) {
        return new AttemptCount(convertToInt(count));
    }

    private static int convertToInt(String count) {
        try {
            return Integer.parseInt(count.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로만 이루어진 문자열이 아닙니다.");
        }
    }

    private void validateValidCount() {
        if (racingAttemptCount < MIN_ATTEMPT_COUNT || racingAttemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_ATTEMPT_COUNT + " ~ " + MAX_ATTEMPT_COUNT + "사이여야합니다.");
        }
    }

    public Integer getAttemptCount() {
        return racingAttemptCount;
    }

}
