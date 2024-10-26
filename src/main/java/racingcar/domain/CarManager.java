package racingcar.domain;

import static racingcar.exception.ExceptionMessage.NOT_PERMIT_SAME_CAR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.RandomNumber;

public class CarManager {

    private static final String INPUT_DELIMITER = ",";

    private List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void setupCarsFromUserInput(String userInput) {
        List<String> split = List.of(userInput.split(INPUT_DELIMITER));
        initCars(split);
    }

    public List<Car> startRacing(RandomNumber randomNumber) {
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
        return cars;
    }

    private void initCars(List<String> carNames) {
        verifyDuplicateCar(carNames);
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void verifyDuplicateCar(List<String> carNames) {
        Set<String> verifyCarNames = new HashSet<>(carNames);
        if(carNames.size() != verifyCarNames.size()) {
            throw new IllegalArgumentException(NOT_PERMIT_SAME_CAR.getMessage());
        }
    }

}
