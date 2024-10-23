package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceUtil {
    private static final String NAME_DELIMITER = ",";
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_THRESHOLD = 4;

    public static String[] parseCarNames(String input) {
        return input.trim().split(NAME_DELIMITER);
    }

    public static boolean canMove(){
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) >= MOVE_THRESHOLD;
    }
}

