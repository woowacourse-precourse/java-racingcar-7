package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseCarNames(String input) {
        String[] carNames = input.split(",");
        return Arrays.stream(carNames).toList();
    }
}
