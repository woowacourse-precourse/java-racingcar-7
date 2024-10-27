package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import racingcar.domain.Car;

public class RacingCarRepository implements CarRepository {

    private static ConcurrentHashMap<String, Car> repository = new ConcurrentHashMap<>();

    private static final RacingCarRepository instance = new RacingCarRepository();

    public static RacingCarRepository getInstance() {

        return instance;
    }

    private RacingCarRepository() {
    }

    @Override
    public void save(Car car) {

        repository.put(car.getName(), car);
    }

    @Override
    public List<Car> findAll() {

        return new ArrayList<>(repository.values());
    }

    @Override
    public void clear() {

        repository.clear();
    }
}