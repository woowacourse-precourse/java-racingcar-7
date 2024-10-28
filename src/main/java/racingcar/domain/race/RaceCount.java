package racingcar.domain.race;

public class RaceCount {
    private static final int MIN_RACE_COUNT = 0;

    private int raceCount;

    private RaceCount(final String raceCount) {
        this.raceCount = validateRaceCount(raceCount);
    }

    public static RaceCount from(final String raceCount) {
        return new RaceCount(raceCount);
    }

    public boolean hasCount() {
        return raceCount > MIN_RACE_COUNT;
    }

    public void decrease() {
        raceCount--;
    }

    private int validateRaceCount(final String raceCount) {
        int count = validateIsInteger(raceCount);
        validateRange(count);
        return count;
    }

    private int validateIsInteger(final String raceCount) {
        try {
            return Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 정수만 가능합니다");
        }
    }

    private void validateRange(final int raceCount) {
        if (raceCount <= MIN_RACE_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 1회 이상으로 입력해 주세요");
        }
    }
}
