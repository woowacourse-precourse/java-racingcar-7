package racingcar.util;

import java.util.List;

public class Parser {
    public static List<String> parseCars(String input) {
        String[] cars = input.split(",");

        return List.of(cars);
    }
}
