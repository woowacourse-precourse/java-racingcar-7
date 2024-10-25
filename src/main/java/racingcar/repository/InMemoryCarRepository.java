package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class InMemoryCarRepository implements CarRepository{
    private static final List<Car> carStore = new ArrayList<>();

    @Override
    public void save(Car car) {
        carStore.add(car);
    }

    @Override
    public List<Car> findAll() {
        return carStore;
    }

    @Override
    public List<Car> findWinners() {
        return null;
    }
}
