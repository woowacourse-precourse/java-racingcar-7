package racingcar.model.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.domain.Car;

public class RacingcarRepository {

    private final Map<String, Car> cars = new LinkedHashMap<>();

    public Car save(Car car) {
        this.cars.put(car.getName(), car);
        return car;
    }

    public List<Car> findAll() {
        return new ArrayList<>(this.cars.values());
    }

    public Car findByName(String name) {
        return this.cars.get(name);
    }

}
