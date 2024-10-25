package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {
    private final String carNames;
    private static final String COMMA = ",";

    public Splitter(String carNames) {
        this.carNames = carNames;
    }

    public List<String> splitSeparator() {
        List<String> splitCarNames = Arrays.stream(carNames.split(COMMA)).toList();
        return trimCarNames(splitCarNames);

    }

    public List<String> trimCarNames(List<String> splitCarNames) {
        return new ArrayList<>(splitCarNames.stream()
                .map(String::trim)
                .toList());
    }
}
