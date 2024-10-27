package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.validators.InputValidator;

public class InputParser {

    public LinkedHashMap<String, Integer> parseCars(String cars) {
        List<String> carsListed = Arrays.asList(cars.replace(" ", "").split(",", -1));

        InputValidator validator = new InputValidator();
        validator.validateCars(carsListed);

        LinkedHashMap<String, Integer> carsParsed = new LinkedHashMap<>();
        for (String car : carsListed) {
            carsParsed.put(car, 0);
        }

        return carsParsed;
    }

    public int parseRounds(String rounds) {
        InputValidator validator = new InputValidator();
        validator.validateRounds(rounds);

        return Integer.parseInt(rounds);
    }
}
