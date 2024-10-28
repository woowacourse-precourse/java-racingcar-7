package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.util.ExceptionChecker;

public class CarsManager {
    private final String input;
    private final List<Car> cars = new ArrayList<>();

    public CarsManager(String input) {
        this.input = input;
        ExceptionChecker.validateNameInput(input);
        setCarNames();
    }

    public void setCarNames() {
        List<String> carNamesArray;
        carNamesArray = Arrays.asList(input.replace(" ", "").split(","));
        for (String carName : carNamesArray) {
            cars.add(new Car(carName));
        }
        ExceptionChecker.validateIsLengthOver(carNamesArray);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
