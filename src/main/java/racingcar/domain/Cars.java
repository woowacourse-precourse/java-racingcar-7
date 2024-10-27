package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public HashMap<String, Integer> getRoundResult() {
        HashMap<String, Integer> result = new HashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getPosition()));
        return result;
    }
}
