package racingcar.wrapper;

public class RaceCount {

    private final int raceCount;

    private RaceCount(String raceCount) {
        int count = validateType(raceCount);
        validateCountRange(count);
        this.raceCount = count;
    }

    public static RaceCount of(String raceCount) {
        return new RaceCount(raceCount);
    }

    private int validateType(String raceCount) {
        int count;
        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("레이스 횟수는 숫자여야 합니다.");
        }
        return count;
    }

    private void validateCountRange(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("레이스 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getRaceCount() {
        return raceCount;
    }

}
