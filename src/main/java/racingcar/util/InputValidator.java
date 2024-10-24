package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNoDuplicates(List<String> list) {
        Set<String> unique = new HashSet<>();
        for (String input : list) {
            if (!unique.add(input))
                throw new IllegalArgumentException();
        }
    }
}
