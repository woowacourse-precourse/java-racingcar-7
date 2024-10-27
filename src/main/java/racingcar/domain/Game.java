package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int tryCount;
    private final List<Car> cars;

    public Game(int tryCount, List<Car> cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void run() {
        cars.forEach(Car::move);
    }

    public HashMap<String, Integer> getRoundResult() {
        HashMap<String, Integer> result = new HashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getPosition()));
        return result;
    }
}
