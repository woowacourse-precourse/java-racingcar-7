package racingcar.view;

import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Input {
    private final Validator validator = new Validator();
    public List<String> userCarInput(String input) {
        validator.checkCarInput(input);
        return Arrays.stream(input.split(",")).map(String::strip).toList();
    }

    public int userNumInput(String input) {
        validator.checkNumInput(input);
        return Integer.parseInt(input);
    }
}
