package racingcar.view;

import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Input {
    private final Validator validator = new Validator();
    public List<String> userInput(String input) {
        validator.checkInput(input);
        return Arrays.stream(input.split(",")).map(String::strip).toList();
    }
}
