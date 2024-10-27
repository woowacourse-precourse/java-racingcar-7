package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    @Override
    public List<Car> findWinners() {
        int maxProgress = carStore.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        return findByProgress(maxProgress);
    }

    private List<Car> findByProgress(int progress) {
        return carStore.stream()
                .filter(car -> car.getProgress() == progress)
                .collect(Collectors.toList());
    }
}
