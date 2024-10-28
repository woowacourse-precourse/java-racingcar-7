package racingcar;

import java.util.List;

public class Validator {
    public static void validateCarNames(List<String> names) {
        for (String name: names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRaceCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
