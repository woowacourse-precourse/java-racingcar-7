package racingcar.model;

import racingcar.validation.Validator;

import java.util.HashMap;
import java.util.Map;

public class Car {

    Map<String, Integer> cars = new HashMap<>();

    public Map<String, Integer> carNameSplit(String carNames){
        String[] tokens = carNames.split(",");

        for(String car : tokens){
            Validator.checkNameLength(car);
            cars.put(car, 0);
        }

        return cars;
    }
}
