package racingcar;

import java.util.List;

public class ExceptionCheck {
    public static void lengthExceedFive(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void intRangeAndNotNegative(String tryCountString) {
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(tryCountString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        if (tryCount < 0) {
            throw new IllegalArgumentException();
        }
    }
}
