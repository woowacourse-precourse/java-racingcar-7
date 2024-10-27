package racingcar.service;

import java.util.HashMap;

public class CarService {

    public HashMap<String, Integer> splitCarNames(String carNames) {
        HashMap<String, Integer> cars = new HashMap<>();

        String[] names = carNames.split(",");

        for (String name : names) {
            cars.put(name.trim(), 0);
        }

        return cars;
    }
}
