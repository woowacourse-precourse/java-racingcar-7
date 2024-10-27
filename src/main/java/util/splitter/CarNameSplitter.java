package util.splitter;

import util.validator.InputValidator;

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
        return new ArrayList<String>(Arrays.asList(input.split(",")));
    }
}