package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class SplitCar {
    private final List<String> carNames;

    public SplitCar(String input) {
        this.carNames = setSplitCarName(input);
    }

    private List<String> setSplitCarName(String input) {
        return Arrays.asList(input.split(","));
    }

    public List<String> getSplitCarNames() {
        return carNames;
    }
}