package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameSplitter {
    private final InputValidator carNameValidator;
    public CarNameSplitter(InputValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<String> splitCarNames(String input) {
        InputValidator carNameValidator = new InputValidator();
        carNameValidator.validate(input);
        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        return carNames;
    }
}