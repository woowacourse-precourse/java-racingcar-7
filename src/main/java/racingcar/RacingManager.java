package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private static final String DELIM = ",";
    private final List<Car> cars;
    private final int trials;

    public RacingManager(String rawName, String rawTrials) {
        this.cars = Arrays.stream(rawName.split(DELIM))
                .map(Car::new)
                .collect(Collectors.toList());
        this.trials = Integer.parseInt(rawTrials);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrials() {
        return trials;
    }
}
