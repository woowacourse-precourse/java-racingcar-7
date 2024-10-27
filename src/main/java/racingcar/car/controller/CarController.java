package racingcar.car.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import racingcar.car.service.CarService;

public class CarController {

    public Map<String, String> createCars() {
        CarService carService = new CarService();
        ArrayList<String> cars = carService.enterCarName();
        Map<String, String> race = new HashMap<>();

        for (String carName : cars) {
            race.put(carName, "");
        }

        return race;
    }
}
