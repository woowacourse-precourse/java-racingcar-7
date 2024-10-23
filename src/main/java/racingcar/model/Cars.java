package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
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
