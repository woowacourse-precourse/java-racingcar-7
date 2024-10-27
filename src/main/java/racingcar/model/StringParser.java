package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final Validation validation;

    public StringParser(Validation validation) {
        this.validation = validation;
    }

    public List<String> findCarNames(String rawNames) {
        List<String> carNames = Arrays.stream(rawNames.split(","))
            .map(String::trim).toList();
        validation.validateCarNameLength(carNames);
        validation.checkEmptyName(carNames);
        return carNames;
    }
}
