package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class Parser {
    private final InputValidator inputValidator = new InputValidator();

    public List<String> parse(String input) {
        inputValidator.checkPrecondition(input);

        List<String> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(inputValidator::check)
                .toList();

        inputValidator.checkResultCondition(result);
        return result;
    }

    public int parseInt(String input) {
        return inputValidator.checkInteger(input);
    }

}
