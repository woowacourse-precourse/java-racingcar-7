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
        String[] carInputs = input.split(",");
        List<Car> inputCars = new ArrayList<>();
        for (String car : carInputs) {
            CarName carName = CarName.from(car.trim());
            inputCars.add(Car.from(carName));
        }
        cars = Cars.from(inputCars);
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

}
