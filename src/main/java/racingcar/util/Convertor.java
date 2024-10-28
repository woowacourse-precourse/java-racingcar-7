package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.ErrorMessage;

public final class Convertor {

    private Convertor() {
    }

    public static List<String> toList(String[] splitCarNames) {
        List<String> cars = Arrays.asList(splitCarNames);
        return new ArrayList<>(cars);
    }

    public static int toInt(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
