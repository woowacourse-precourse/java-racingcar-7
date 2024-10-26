package racingcar.domain;

import java.util.List;

public class Parser {
    public static List<String> parse(String rawCarNames) {

        List<String> carNames = List.of(rawCarNames.split(","));

        return carNames;
    }
}
