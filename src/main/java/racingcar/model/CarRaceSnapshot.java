package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRaceSnapshot {
    private static final int DEFAULT_MAX_DISTANCE = 0;

    private final List<String> carNames = new ArrayList<>();
    private final List<Integer> carMoveDistances = new ArrayList<>();

    public CarRaceSnapshot(final Cars cars) {
        captureSnapshot(cars);
    }

    private void captureSnapshot(final Cars cars) {
        cars.getCars().forEach(car -> {
            carNames.add(car.getName());
            carMoveDistances.add(car.getMoveDistance());
        });
    }

    public List<String> getMaxDistanceCarsName() {
        int maxDistance = getMaxDistance();
        return findCarsWithDistance(maxDistance);
    }

    private int getMaxDistance() {
        return carMoveDistances.stream()
                .max(Integer::compare)
                .orElse(DEFAULT_MAX_DISTANCE);
    }

    private List<String> findCarsWithDistance(final int distance) {
        return IntStream.range(0, carMoveDistances.size())
                .filter(i -> carMoveDistances.get(i) == distance)
                .mapToObj(carNames::get)
                .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarMoveDistances() {
        return carMoveDistances;
    }
}
