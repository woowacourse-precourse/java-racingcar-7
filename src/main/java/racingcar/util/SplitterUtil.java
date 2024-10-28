package racingcar.util;

import static racingcar.util.UtilConstants.DELIMITER;

public class SplitterUtil {

    public static String[] splitCarNames(final String carNames) {
        return carNames.split(DELIMITER.getValue());
    }

}
