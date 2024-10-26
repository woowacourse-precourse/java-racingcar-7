package racingcar.model;

import java.util.LinkedHashMap;

public class InputParser {

    public LinkedHashMap<String, Integer> getCarsHashMap(String cars) {
        LinkedHashMap<String, Integer> cars_parsed = new LinkedHashMap<>();

        String[] cars_list = cars.replace(" ", "").split(",", -1);

        for (String car : cars_list) {
            cars_parsed.put(car, 0);
        }

        return cars_parsed;
    }
}
