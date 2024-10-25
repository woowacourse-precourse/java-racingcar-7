package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final String INPUT_COUNT_PATTERN = "^[1-9][0-9]*";
    private final String INPUT_CARS_PATTERN = "^[^\\s,]{1,5}(,[^\\s,]{1,5})*";

    public void validate(String inputCars, String inputCount) {
        Pattern patternInputCount = Pattern.compile(INPUT_COUNT_PATTERN);
        Matcher matcherInputCount = patternInputCount.matcher(inputCount);

        Pattern patternInputCars = Pattern.compile(INPUT_CARS_PATTERN);
        Matcher matcherInputCars = patternInputCars.matcher(inputCars);

        if (!matcherInputCount.matches() || !matcherInputCars.matches()) {
            throwError();
        }
    }

    public void throwError() {
        throw new IllegalArgumentException();
    }
}
