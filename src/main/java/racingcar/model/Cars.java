package racingcar.model;

import static racingcar.util.CarNameValidator.checkDuplicate;
import static racingcar.util.CarNameValidator.checkEmpty;
import static racingcar.util.RandomNumberGenerator.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.CarNameValidator;

public class Cars {
    
    private final List<Car> cars;

    public Cars(List<String> input) {
        this.cars = new ArrayList<>();
        checkInputCarNames(input);
        addCars(input);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void carsMovement(List<Car> cars) {
        for (Car car : cars) {
            car.carMove(generateRandomNumber());
        }
    }

    private void checkInputCarNames(List<String> input) {
        checkEmpty(input);
        checkDuplicate(input);
    }

    private void addCars(List<String> names) {
        for (String carName : names) {
            this.cars.add(new Car(carName));
        }
    }
}
