package racingcar.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import racingcar.model.car.Car;

public class Carrier {
    private final List<Car> cars;

    public Carrier() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void adaptAll(Consumer<Car> consumer) {
        cars.forEach(consumer);
    }

    public List<Car> aggregateTop() {
        int maxValue = max();
        return cars.stream().filter(car -> car.getDistance() == maxValue).collect(Collectors.toList());
    }

    private int max() {
        return cars.stream().map(Car::getDistance).max(Integer::compareTo).get();
    }
}
