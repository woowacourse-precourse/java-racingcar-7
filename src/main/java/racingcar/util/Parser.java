package racingcar.util;

import java.util.List;

public class Parser {
    public static List<String> parseCars(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException();
        String[] cars = input.split(",");

        return List.of(cars);
    }
}
