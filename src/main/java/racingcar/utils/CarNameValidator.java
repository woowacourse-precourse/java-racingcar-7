package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarNameValidator {

    public List<Car> processCarName(String inputCarNames) {
        validateCarNamesInput(inputCarNames);
        String[] carNames = extractCarName(inputCarNames);
        return createCars(carNames);
    }

    public void validateCarNamesInput(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String[] extractCarName(String carNames) {
        return carNames.split(",");
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        final int START_POSITION = 0;

        for (String carName : carNames) {
            Car car = createCar(carName, START_POSITION);
            cars.add(car);
        }
        return cars;
    }

    public Car createCar(String carName, int initialPosition) {
        String trimmedCarName = carName.trim();
        if ( trimmedCarName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Car(trimmedCarName, initialPosition);
    }
}
