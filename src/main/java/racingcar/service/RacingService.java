package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarName;
import racingcar.utils.Validator;

public class RacingService {
    private Cars cars;

    public void initializeCars(String input) {
        List<Car> inputCars = createCarsFromInput(input);
        cars = Cars.from(inputCars);
    }

    public int insertTryCount(String input) {
        try {
            Validator.validateNumericInput(input);
            int attemptCount = Integer.parseInt(input);
            Validator.validateAttemptCount(attemptCount);
            return attemptCount;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void moveCars() {
        cars.allMove();
    }

    public List<String> findWinners() {
        return cars.findRaceWinners();
    }

    public List<String> fetchCarNames() {
        return cars.fetchCarNames();
    }

    public List<Integer> fetchCarsPositions() {
        return cars.fetchCarsPositions();
    }

    private List<Car> createCarsFromInput(String input) {
        String[] carInputs = input.split(",");
        List<Car> inputCars = new ArrayList<>();
        for (String car : carInputs) {
            CarName carName = createCarName(car.trim());
            inputCars.add(Car.from(carName));
        }
        return inputCars;
    }

    private CarName createCarName(String name) {
        return CarName.from(name);
    }
}