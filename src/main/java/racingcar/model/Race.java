package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private List<Car> cars;
    private int count;

    Race(String inputtedName, int count) {
        String[] carNames = inputtedName.split(DELIMITER, -1);
        cars = Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());

        this.count = count;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }
}
