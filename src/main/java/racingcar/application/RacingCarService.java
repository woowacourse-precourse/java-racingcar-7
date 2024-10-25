package racingcar.application;

import racingcar.domain.application.RaceService;
import racingcar.domain.model.Car;
import racingcar.domain.model.CarRepository;

import java.util.Arrays;
import java.util.List;

public class RacingCarService {

    private final CarRepository carRepository;

    public RacingCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCars(String[] names) {
        List<Car> cars = Arrays.stream(names)
                .map(Car::create)
                .toList();

        carRepository.saveAll(cars);
    }

}
