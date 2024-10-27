package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameSplitter {
    private final InputValidator inputValidator;
    public CarNameSplitter(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> splitCarNames(String input) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.inputValidate(input);
        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        return carNames;
    }
}