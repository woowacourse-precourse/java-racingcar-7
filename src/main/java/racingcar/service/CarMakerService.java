package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class CarMakerService {
    private final CarNameValidator carNameValidator;

    public CarMakerService(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<Car> makeCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] carNamesArray = carNames.split(",");

        for (String carName : carNamesArray) {
            carNameValidator.isNotEmpty(carName);
            carNameValidator.isLengthUnderFive(carName);

            cars.add(new Car(carName));
        }

        return cars;
    }
}
