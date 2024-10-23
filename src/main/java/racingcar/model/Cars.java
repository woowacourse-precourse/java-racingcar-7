package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        validateUniqueName(names);

        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateUniqueName(String[] names) {
        Set<String> uniqueNames = new HashSet<>(List.of(names));

        if (names.length != uniqueNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public SequencedMap<String, Integer> getStatus() {
        SequencedMap<String, Integer> carStatusMap = new LinkedHashMap<>();
        cars.forEach(car -> carStatusMap.put(car.getName(), car.getPosition()));
        return carStatusMap;
    }

    public int getSize() {
        return cars.size();
    }

    public void move(int index) {
        cars.get(index).move();
    }
}
