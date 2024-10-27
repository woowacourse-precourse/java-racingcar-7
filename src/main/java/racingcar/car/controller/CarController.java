package racingcar.car.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import racingcar.car.service.CarService;

public class CarController {

    public Map<String, String> createCars() {
        CarService carService = new CarService();
        ArrayList<String> carList = carService.enterCarName();
        Map<String, String> cars = new HashMap<>();

        for (String carName : carList) {
            cars.put(carName, "");
        }

        return cars;
    }
}
