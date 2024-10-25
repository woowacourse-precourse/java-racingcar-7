package service;

import error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class InputService {
    public InputService() {
    }

    public String validateCarName(String newCarName) {
        newCarName = newCarName.trim();

        if (newCarName.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY);
        }

        int carNameLength = newCarName.length();
        if (carNameLength > 5) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_INVALID);
        }

        return newCarName;
    }

    public List<String> extractValidCarNames(String cars) {
        List<String> validCarNames = new ArrayList<>();

        cars = cars.trim();

        if (cars.charAt(cars.length() - 1) == ',') {
            throw new IllegalArgumentException(ExceptionMessage.CARS_INPUT_END_ERROR);
        }

        String[] carNames = cars.split(",");
        if (carNames.length == 1) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_ONE_CAR);
        }

        for (String newCarName : carNames) {
            newCarName = validateCarName(newCarName);
            validCarNames.add(newCarName);
        }

        return validCarNames;
    }

    public int validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.COUNTS_VALUE_INVALID);
        }
        return count;
    }
}
