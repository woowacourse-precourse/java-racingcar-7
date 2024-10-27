package parser;

import java.util.Arrays;
import java.util.List;
import validator.Validator;

public class RacingCarParser {
    private static final String carSeparator = ",";
    private final Validator validator;

    public RacingCarParser(Validator validator) {
        this.validator = validator;
    }

    public List<String> parseRacingCar(String input) {
        List<String> carNames = Arrays.stream(input.split(carSeparator, -1))
                .map(String::trim)
                .toList();
        validator.validateCar(carNames);
        return carNames;
    }
}
