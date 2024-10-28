package racingcar.util;

public class RaceCountValidator {

    public static void validate(String raceCountStr) {

        isEmpty(raceCountStr);
        int raceCount = parseInt(raceCountStr);
        validateRange(raceCount);

    }

    private static void isEmpty(String raceCount) {

        if (raceCount == null || raceCount.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }
    }

    private static int parseInt(String raceCount) {

        try {
            return Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경주 횟수를 정수로 입력하세요.", e);
        }
    }

    private static void validateRange(Integer raceCount) {

        if (raceCount < 1) {
            throw new IllegalArgumentException("경주 횟수는 한 번 이상 2147483647 이하 입니다.");
        }
    }


}
