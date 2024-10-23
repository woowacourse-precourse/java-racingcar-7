package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceUtil {
    private static final String NAME_DELIMITER = ",";

    public static String[] parseCarNames(String input) {
        return input.trim().split(NAME_DELIMITER);
    }
}

