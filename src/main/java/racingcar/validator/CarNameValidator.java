package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

import static racingcar.constants.Constants.*;

public class CarNameValidator {

    private final String cars;
    private final List<String> carList;

    public CarNameValidator(String cars) {
        this.cars = cars;
        this.carList = List.of(cars.split(DELIMITER));
    }

    public void verify() {
        rightNamePattern();
        nameLength();
        nameOverlap();
    }

    private void nameLength() {
        for (String car : carList) {
            if (car.isEmpty() || car.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
    }

    private void nameOverlap() {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

    private void rightNamePattern() {
        if (!Pattern.compile(CAR_LIST_PATTERN).matcher(cars).matches()) {
            throw new IllegalArgumentException(CAR_NAME_WRONG_ERROR);
        }
    }

    public List<String> getCarList() {
        return carList;
    }
}

