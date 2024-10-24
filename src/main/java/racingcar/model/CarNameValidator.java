package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameValidator {
    public final String name;
    public final List<String> cars;

    public CarNameValidator(String carName) {
        this.name = carName;
        this.cars = new ArrayList<>(Arrays.asList(carName.split(",")));
        validate();
    }

    public void validate() {
        isValidCarName();
        isDuplicate();
    }

    public void isValidCarName() {
        for (String car : cars) {
            if (car.isEmpty() || car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isDuplicate() {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
