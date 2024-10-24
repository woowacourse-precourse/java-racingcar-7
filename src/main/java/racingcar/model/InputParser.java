package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parse(String initialInput) {
        return Arrays.stream(initialInput.split(",")).toList();
    }
}
