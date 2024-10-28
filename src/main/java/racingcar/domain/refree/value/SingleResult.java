package racingcar.domain.refree.value;

import racingcar.domain.car.Car;
import racingcar.domain.car.value.Distance;
import racingcar.domain.car.value.Name;

import java.util.*;
import java.util.stream.Collectors;

public class SingleResult {

    private final Map<Name, Distance> value = new HashMap<>();

    public void insert(Car car) {
        Name name = car.getName();
        Distance distance = car.getDistance();

        value.put(name, distance);
    }

    public Collection<Distance> getDistanceValues() {
        return value.values();
    }

    public List<Name> findByValue(int max) {
        return value.entrySet().stream()
                .filter(entry -> entry.getValue().getValue() == max)
                .map(Map.Entry::getKey)
                .toList();
    }


    @Override
    public String toString() {
        return value.entrySet().stream()
                .map(e -> String.format("%s : %s%n", e.getKey(), e.getValue().getTextValue()))
                .collect(Collectors.joining());
    }
}
