package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private static final String DELIM = ",";
    private int trials;

    public List<Car> assignCars(String input) {
        return Arrays.stream(input.split(DELIM))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void assignTrials(int trials) {
        this.trials = trials;
    }

    public int getTrials() {
        return trials;
    }
}
