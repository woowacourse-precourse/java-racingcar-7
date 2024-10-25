package racingcar.model;

public class AttemptCount {

    public static final Integer MIN_ATTEMPT_COUNT = 1;
    public static final Integer MAX_ATTEMPT_COUNT = 10;

    private final Integer racingAttemptCount;

    public AttemptCount(Integer count) {
        this.racingAttemptCount = count;
        validateValidCount();
    }

    public static AttemptCount fromString(String count) {
        return new AttemptCount(convertInteger(count));
    }

    private static Integer convertInteger(String count) {
        try {
            return Integer.parseInt(count.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로만 이루어진 문자열이 아닙니다.");
        }
    }

    private void validateValidCount() {
        if(racingAttemptCount < MIN_ATTEMPT_COUNT || racingAttemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_ATTEMPT_COUNT + " ~ " + MAX_ATTEMPT_COUNT + "사이여야합니다.");
        }
    }

    public Integer getAttemptCount() {
        return racingAttemptCount;
    }

}
