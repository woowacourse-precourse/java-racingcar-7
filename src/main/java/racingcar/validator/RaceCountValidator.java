package racingcar.validator;

public class RaceCountValidator {

    public static int validateRaceCount(String raceCount) {
        int count = validateType(raceCount);
        validateCountRange(count);

        return count;
    }

    private static int validateType(String raceCount) {
        int count;
        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("레이스 횟수는 숫자여야 합니다.");
        }

        return count;
    }

    private static void validateCountRange(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("레이스 횟수는 1 이상이어야 합니다.");
        }
    }

}
