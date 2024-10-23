package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceUtil {
    private static final String NAME_DELIMITER = ",";
    private static final String ERROR_ATTEMPTS = "시도 횟수는 1 이상이어야 합니다.";
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_ATTEMPTS = 1;

    public static String[] parseCarNames(String input) {
        return input.trim().split(NAME_DELIMITER);
    }

    public static boolean canMove(){
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) >= MOVE_THRESHOLD;
    }

    public static void validateAttempts(int attempts) {
        if (attempts < MIN_ATTEMPTS) {
            throw new IllegalArgumentException(ERROR_ATTEMPTS);
        }
    }
}

