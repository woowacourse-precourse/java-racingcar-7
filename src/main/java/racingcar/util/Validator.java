package racingcar.util;

import racingcar.racing.Car;

import java.util.List;

public class Validator {
    public static final int STANDARD_NUMBER = 4;

    public static boolean canMove(int randomNumber) {
        return randomNumber >= STANDARD_NUMBER;
    }

    public static void isNotEmptyCarList(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_LIST_EMPTY_ERROR_MESSAGE.getMessage());
        }
    }
}
