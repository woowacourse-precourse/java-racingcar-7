package racingcar.repository.impl;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarRepositoryImpl implements CarRepository {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public void saveAll(List<Car> carsInput) {
        for (Car car : carsInput) {
            this.save(car);
        }
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findByName(String carName) {
        return cars.stream()
                .filter((car) -> car.getName().equals(carName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }
}
