package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;

public class InMemoryCarRepository implements CarRepository {
    private final List<Car> carList = new ArrayList<>();
    private static final InMemoryCarRepository INSTANCE = new InMemoryCarRepository();

    private InMemoryCarRepository() {

    }

    public static InMemoryCarRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Car car) {
        carList.add(car);
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carList);
    }

    @Override
    public void updateAll(List<Car> carList) {
        this.carList.clear();
        this.carList.addAll(carList);
    }

}
