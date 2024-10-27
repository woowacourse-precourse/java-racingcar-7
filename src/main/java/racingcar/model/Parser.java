package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.validation.InputValidator;

public class Parser {

    public List<String> parseCarName(String input) {
        InputValidator.validateCarNames(input);

        List<String> result = new ArrayList<>();
        String[] names = input.split(",");

        for (String name : names) {
            result.add(name);
        }

        return result;
    }

    public int parseCount(String input) {
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
