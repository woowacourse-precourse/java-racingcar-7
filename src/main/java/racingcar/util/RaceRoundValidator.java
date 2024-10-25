package racingcar.util;

public class RaceRoundValidator {
    private static final int MAX_RACE_ROUND = 100;
    private static final int MIN_RACE_ROUND = 0;

    public static void validateRaceRound(String rawRaceRound) {
        validateNumberFormat(rawRaceRound);
        int raceRound = parseRaceRound(rawRaceRound);
        validateRaceRoundInBound(raceRound);
    }

    private static void validateNumberFormat(String rawRaceRound) {
        if (!rawRaceRound.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateRaceRoundInBound(int raceRound) {
        if (raceRound < MIN_RACE_ROUND || raceRound > MAX_RACE_ROUND) {
            throw new IllegalArgumentException("진행 횟수의 범위는 0부터 100까지입니다.");
        }
    }

    private static int parseRaceRound(String rawRaceRound) {
        try {
            return Integer.parseInt(rawRaceRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 정수를 입력하세요.");
        }
    }
}
