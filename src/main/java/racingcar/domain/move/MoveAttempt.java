package racingcar.domain.move;


import java.util.Objects;
import java.util.regex.Pattern;

public class MoveAttempt {
    private static final String REGEX_NATURAL_NUMBER = "^[1-9]\\d*$";
    private static final int THRESHOLD = 1;
    private static final Pattern PATTERN = Pattern.compile(REGEX_NATURAL_NUMBER);
    private final int count;

    public static MoveAttempt of(String attempt) {
        return new MoveAttempt(attempt);
    }
    public static MoveAttempt of(int attemptValue) {
        return new MoveAttempt(attemptValue);
    }

    private MoveAttempt(String attemptString) {
        validate(attemptString);
        this.count = Integer.parseInt(attemptString);
    }

    private MoveAttempt(int attemptCount) {
        if(attemptCount < THRESHOLD) {
            throwIllegalArgumentException(String.valueOf(attemptCount));
        }
        this.count = attemptCount;
    }

    private void validate(String attemptString) {
        if (PATTERN.matcher(attemptString).matches()) {
            return;
        }
        throwIllegalArgumentException(attemptString);
    }

    private void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message + " is not a valid move attempt count");
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveAttempt that = (MoveAttempt) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
