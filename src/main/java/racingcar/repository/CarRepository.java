package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Car;

public class CarRepository {

    private static CarRepository instance;

    private CarRepository() {

    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    private int id = 0;
    private Map<Integer, Car> cars = new HashMap<>();

    public void save(Car car) {
        car.setId(id);
        cars.put(id, car);
        id++;
    }

    public Car saveAndReturn(Car car) {
        car.setId(id);
        cars.put(id, car);
        id++;
        return car;
    }

    public void update(Car car) {
        cars.replace(car.getId(), car);
    }

    public Car findByCarId(int id) {
        return cars.get(id);
    }

    public Car findByCarName(String name) {
        return cars.values().stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
