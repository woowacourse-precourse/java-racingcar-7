package racingcar.util;

import racingcar.validation.Validator;

public class Saparator {

    private String delimiter;

    public Saparator(String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] split(String input) {
        Validator.validateNull(input);
        Validator.validateEmpty(input);
        return input.split(delimiter);
    }
}
