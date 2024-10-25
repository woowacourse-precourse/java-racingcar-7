package racingcar.util;

public class NumberUtil {

    public static int toNumber(String input) {
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 횟수에는 숫자를 입력해야 합니다");
        }

        return tryCount;
    }
}
