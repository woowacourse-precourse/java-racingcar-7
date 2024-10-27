package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class InMemoryCarRepository implements CarRepository{
    private final List<Car> carStore;

    private InMemoryCarRepository() {
        carStore = new ArrayList<>();
    }

    private static class Holder {
        private static final InMemoryCarRepository INSTANCE = new InMemoryCarRepository();
    }

    public static InMemoryCarRepository getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void save(Car car) {
        carStore.add(car);
    }

    @Override
    public List<Car> findAll() {
        return carStore;
    }
}
