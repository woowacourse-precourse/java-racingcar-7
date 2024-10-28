package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.UserInputProcessorValidator;

public class UserInputProcessor {
    private static final String CAR_NAME_DELIMITER = ",";
    private final UserInputProcessorValidator userInputProcessorValidator = new UserInputProcessorValidator();

    public List<String> processCarName(String userInput) {
        return extractCarName(userInput)
                .stream()
                .map(this::removeBlank)
                .toList();
    }

    public Integer processTotalAttempts(String userInput) {
        return parseStringToInteger(removeBlank(userInput));
    }

    private List<String> extractCarName(String userInput) {
        return Arrays.stream(userInput.split(CAR_NAME_DELIMITER))
                .map(this::removeBlank)
                .filter(carName -> !carName.isEmpty())
                .toList();
    }

    private String removeBlank(String userInput) {
        return userInput.trim();
    }

    private Integer parseStringToInteger(String userInput) {
        long tempTotalAttempts = Long.parseLong(userInput);
        userInputProcessorValidator.validateTotalAttemptsOverflow(tempTotalAttempts);
        return (int) tempTotalAttempts;
    }
}
