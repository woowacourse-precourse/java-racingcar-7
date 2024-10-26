package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameSplitter {
    public List<String> splitNames(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.stream(input.split(","))
                .map(String::strip)
                .filter(this::isNotEmpty)
                .toList();
    }

    private boolean isNotEmpty(String name) {
        return !name.isEmpty();
    }
}