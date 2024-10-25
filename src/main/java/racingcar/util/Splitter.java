package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private final String carNames;
    private static final String COMMA = ",";

    public Splitter(String carNames) {
        this.carNames = carNames;
    }

    public List<String> splitSeparator() {
        return Arrays.stream(carNames.split(COMMA)).toList();
    }
}
