package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CarRepositoryImpl implements CarRepository {

    private static List<Car> cars = new ArrayList<>();

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Optional<Car> findByName(String name) {
        return cars.stream().filter(car -> car.getName().equals(name)).findAny();
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    public void clear() {
        cars.clear(); // 테스트를 위해 레포지토리를 초기화
    }

}
