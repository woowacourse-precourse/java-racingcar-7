package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {

    }

    public static Cars parseCar(final String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.replaceAll(String::trim);

        return new Cars(carNames);
    }

    public static PlayCount parsePlayCount(final String input) {
        return new PlayCount(input);
    }
}
