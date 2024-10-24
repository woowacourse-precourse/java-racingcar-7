package service;

import error.ExceptionMessage;
import model.CarList;

public class InputService {
    private final CarList carList;
    private final CarService carService;

    public InputService() {
        this.carList = new CarList();
        this.carService = new CarService();
    }

    public CarList extractValidCar(String cars) {
        cars = cars.trim();

        if (cars.charAt(cars.length() - 1) == ',') {
            throw new IllegalArgumentException(ExceptionMessage.CARS_INPUT_END_ERROR);
        }

        String[] carNames = cars.split(",");
        if (carNames.length == 1) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_ONE_CAR);
        }

        for (String newCarName : carNames) {
            newCarName = carService.validateCarName(newCarName);
            carList.addCar(newCarName);
        }

        return carList;
    }

    public int validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.COUNTS_VALUE_INVALID);
        }
        return count;
    }
}
