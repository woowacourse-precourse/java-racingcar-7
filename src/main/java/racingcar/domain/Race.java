package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final ArrayList<Car> carArrayList;
    private final int attemptCount;

    public Race(final ArrayList<Car> carArrayList, final int attemptCount) {
        this.carArrayList = carArrayList;
        this.attemptCount = attemptCount;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public List<Integer> getDistanceList() {
        return getCarArrayList().stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }
}
