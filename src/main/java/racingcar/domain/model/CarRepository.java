package racingcar.domain.model;

import racingcar.domain.model.value.Name;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.Const.DUPLICATE_NAME;


public class CarRepository {

    private final Map<Name, Car> storedCars = new HashMap<>();

    public Car save(Car car) {
        try {
            return storedCars.put(car.getName(), car);
        } catch (IllegalArgumentException e) {
            throw new DuplicateNameException(DUPLICATE_NAME);
        }
    }

    public void saveAll(List<Car> carsToAdd) {

        try {
            saveAllCars(carsToAdd);
        } catch (IllegalArgumentException e) {
            throw new DuplicateNameException(DUPLICATE_NAME);
        }
    }

    private void saveAllCars(List<Car> carsToAdd) {
        Map<Name, Car> cars = carsToAdd.stream()
                .collect(
                        Collectors.toMap(Car::getName, car -> car)
                );
        storedCars.putAll(cars);
    }

    public List<Car> findAll() {
        return storedCars.values()
                .stream()
                .toList();
    }

    public Optional<Car> findByName(Name name) {
        Car car = storedCars.get(name);
        return Optional.ofNullable(car);
    }
}
