package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.ExceptionMessages;

public class InputParser {
    private InputParser() {
    }

    public static List<String> parseCarNames(String carNamesInput) {
        validateInput(carNamesInput);
        List<String> carNames = Arrays.stream(carNamesInput.split(",")).toList();

        validateCarNames(carNames);
        return (carNames);
    }

    public static int parseRounds(String roundsInput) {
        validateInput(roundsInput);
        validateRounds(roundsInput);
        return Integer.parseInt(roundsInput);
    }

    private static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_INPUT.getMessage());
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATE_NAME.getMessage());
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessages.TOO_LONG_NAME.getMessage());
            }
            if (carName.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessages.EMPTY_CAR_NAME.getMessage());
            }
        }
    }

    private static void validateRounds(String roundsInput) {
        int rounds;

        try {
            rounds = Integer.parseInt(roundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_NOT_NUMBER.getMessage());
        }
        if (rounds < 0) {
            throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_NUMBER.getMessage());
        }
    }
}
