package service;

import java.util.HashMap;
import java.util.Map;

public class Race {

    public String Racing(String carString, String attempt) {

        Map<String, Integer> cars = storeCars(carString);

    }

    private Map<String, Integer> storeCars(String input) {

        Map<String, Integer> cars = new HashMap<>();

        String[] tokens = input.split(",");

        for(String token : tokens) {

            cars.put(token, 0);
        }

        return cars;
    }
}
