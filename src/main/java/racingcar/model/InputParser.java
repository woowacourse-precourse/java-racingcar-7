package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.validators.InputValidator;

public class InputParser {

    public LinkedHashMap<String, Integer> parseCarNames(String cars) {
        List<String> cars_list = Arrays.asList(cars.replace(" ", "").split(",", -1));

        InputValidator validator = new InputValidator();
        validator.validateCars(cars_list);

        LinkedHashMap<String, Integer> cars_parsed = new LinkedHashMap<>();
        for (String car : cars_list) {
            cars_parsed.put(car, 0);
        }

        return cars_parsed;
    }

    public int parseTotalRounds(String rounds) {
        InputValidator validator = new InputValidator();
        validator.validateRounds(rounds);

        return Integer.parseInt(rounds);
    }
}
