package racingcar.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private int maxPosition;

    public void findMaxPosition(Map<String, Integer> cars) {
        maxPosition = Collections.max(cars.values());
    }

    public Set<String> findWinningCars(Map<String, Integer> cars) {

        return cars.entrySet().stream()
                .filter(car -> car.getValue() == maxPosition)
                .map(Entry::getKey)
                .collect(Collectors.toSet());

    }
}
