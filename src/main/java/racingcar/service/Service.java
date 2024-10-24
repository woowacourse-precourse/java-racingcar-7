package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;

public class Service {
    private static final String COMMA = ",";

    public ArrayList<String> splitCarNames(final String carNames) {
        return new ArrayList<>(Arrays.stream(carNames.split(COMMA)).toList());
    }
}
