package racingcar.validator;

import racingcar.message.VaildatorMessage;

public class TryVaildator {
    public static void tryVaildator(String tryCount) {
        parseTryCount(tryCount);
    }

    private static int parseTryCount(String tryCount) {
        if (!tryCount.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(VaildatorMessage.NOT_NUM_INPUT.getMessage());
        }
        return Integer.parseInt(tryCount);
    }
}
