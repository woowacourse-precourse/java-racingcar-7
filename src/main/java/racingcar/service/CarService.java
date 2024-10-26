package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validator.Validator;
import racingcar.validator.impl.NameValidator;

public class CarService {
    CarRepository carRepository;
    Validator validator;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.validator = new NameValidator();
    }

    public void saveAllByString(String rawNames) {
        rawNames = rawNames.replaceAll(" ", "");
        List<String> carNames = List.of(rawNames.split(","));
        validator.validate(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        carRepository.saveAll(cars);
    }
}
