package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseName(String initialInput) {
        return Arrays.stream(initialInput.split(",")).toList();
    }
}