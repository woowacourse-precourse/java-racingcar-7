package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.validators.CarsValidator;
import racingcar.validators.RoundsValidator;

public class InputParser {

    public LinkedHashMap<String, Integer> parseCars(String cars) {
        List<String> carsListed = Arrays.asList(cars.replace(" ", "").split(",", -1));

        CarsValidator carsValidator = new CarsValidator(carsListed);
        carsValidator.validate();

        LinkedHashMap<String, Integer> carsParsed = new LinkedHashMap<>();
        for (String car : carsListed) {
            carsParsed.put(car, 0);
        }

        return carsParsed;
    }

    public int parseRounds(String rounds) {
        RoundsValidator roundsValidator = new RoundsValidator(rounds);
        roundsValidator.validate();

        return Integer.parseInt(rounds);
    }
}
