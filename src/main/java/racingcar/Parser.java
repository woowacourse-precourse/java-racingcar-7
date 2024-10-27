package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static Cars parseCar(final String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return new Cars(carNames);
    }
}
