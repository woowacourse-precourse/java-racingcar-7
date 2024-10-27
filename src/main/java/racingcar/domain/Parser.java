package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class Parser {
    private final InputValidator inputValidator = new InputValidator();

    public List<String> parse(String input) {
        inputValidator.checkPrecondition(input);

        return Arrays.stream(input.trim()
                .split(","))
                .map(inputValidator::check)
                .toList();
    }

    public int parseInt(String input) {
        return inputValidator.checkInteger(input);
    }

}
