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
}
