package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validator.Validator;

public class CarService {
    private final CarRepository carRepository;
    private final Validator validator;

    public CarService(CarRepository carRepository, Validator validator) {
        this.carRepository = carRepository;
        this.validator = validator;
    }

    public void saveAllByInput(String inputNames) {
        inputNames = inputNames.replaceAll(" ", "");
        List<String> carNames = List.of(inputNames.split(","));
        validator.validate(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        carRepository.saveAll(cars);
    }
}
