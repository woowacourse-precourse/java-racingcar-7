package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import racingcar.domain.Car;

public class RacingCarRepository implements CarRepository {

    private static ConcurrentHashMap<String, Car> repository = new ConcurrentHashMap<>();

    @Override
    public void save(Car car) {
        repository.put(car.getName(), car);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(repository.values());
    }
}