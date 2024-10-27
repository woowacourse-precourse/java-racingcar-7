package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.Arrays;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(String[] carName) {
        Arrays.stream(carName)
                .map(Car::new)
                .forEach(carRepository::save);
    }
}