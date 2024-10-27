package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class CarRepository {
    private static Long id = 0L;
    private static final Map<Long, Car> carMap = new HashMap<>();

    public void save(Car car) {
        id = id + 1;
        car.setId(id);
        carMap.put(car.getId(), car);
    }

    public static Long getId() {
        return id;
    }

    public Car findById(Long id) {
        return carMap.get(id);
    }

    public List<Car> findAll() {
        return new ArrayList<>(carMap.values());
    }
}
