package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Convertor {

    private Convertor() {
    }

    public static List<String> toList(String[] splitCarNames) {
        List<String> cars = Arrays.asList(splitCarNames);
        return new ArrayList<>(cars);
    }
}
