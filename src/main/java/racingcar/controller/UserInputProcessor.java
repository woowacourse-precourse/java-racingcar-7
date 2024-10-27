package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class UserInputProcessor {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> processCarName(String userInput) {
        return extractCarName(userInput)
                .stream()
                .map(this::removeBlank)
                .toList();
    }


    private List<String> extractCarName(String userInput) {
        return Arrays.stream(userInput.split(CAR_NAME_DELIMITER)).toList();
    }

    private String removeBlank(String userInput) {
        return userInput.trim();
    }
}
