package racingcar;

import view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public void add(String carName) {
        carNameValidation(carName);
        carList.add(new Car());
    }

    private void carNameValidation(String carName) {
        isNull(carName);
        isOverSizeCarName(carName);
    }

    private void isOverSizeCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print());
        }
    }

    private void isNull(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
        }
    }
}
