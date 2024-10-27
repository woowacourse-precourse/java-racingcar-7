package racingcar.model;

import java.util.regex.Pattern;

public class RaceCount {
    private final int raceCount;

    private static final Pattern RACE_TIMES_PATTERN = Pattern.compile("/^[0-9]*$/");

    public RaceCount(String raceCount) {
        this.raceCount = Integer.parseInt(raceCount);
    }

    public int getValue() {
        return raceCount;
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

    public static void hasCharacters(String raceCount) {
        if (!RACE_TIMES_PATTERN.matcher(raceCount).matches()) {
            throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
        }
    }

    public static void isBlank(String raceCount) {
        if (raceCount == null || raceCount.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 빈 값이 될 수 없습니다.");
        }
    }

    public static void isZero(String raceCount) {
        if (raceCount.equals("0")) {
            throw new IllegalArgumentException("시도 횟수는 0이 될 수 없습니다.");
        }
    }
}
