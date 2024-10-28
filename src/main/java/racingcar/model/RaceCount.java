package racingcar.model;

import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.constants.ErrorMessage;

public class RaceCount {
    private final int raceCount;

    private static final Pattern RACE_TIMES_PATTERN = Pattern.compile("/^[0-9]*$/");

    public RaceCount(String raceCount) {
        this.raceCount = Integer.parseInt(raceCount);
    }

    public int getValue() {
        return raceCount;
    }

    public static void hasCharacters(String raceCount) {
        if (!RACE_TIMES_PATTERN.matcher(raceCount).matches()) {
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_DOES_NOT_HAVE_CHARACTER.getErrorMessage());
        }
    }

    public static void isBlank(String raceCount) {
        if (raceCount == null || raceCount.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_CAN_NOT_BE_EMPTY.getErrorMessage());
        }
    }

    public static void isZero(String raceCount) {
        if (raceCount.equals("0")) {
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_CAN_NOT_BE_ZERO.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RaceCount comparingRaceCount = (RaceCount) obj;
        return raceCount == comparingRaceCount.raceCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCount);
    }
}
