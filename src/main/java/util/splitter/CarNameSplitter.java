package util.splitter;

import util.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameSplitter {
    private final CarNameValidator carNameValidator;
    public CarNameSplitter(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<String> splitCarNames(String input) {
        CarNameValidator carNameValidator = new CarNameValidator();
        carNameValidator.validate(input);
        return new ArrayList<String>(Arrays.asList(input.split(",")));
    }
}