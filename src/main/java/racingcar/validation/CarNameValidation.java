package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidation {
    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIncludeComma(input);
        validateNotEndWithComma(input);
        validateCarName(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIncludeComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEndWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateCarName(String input) {
        String[] carNames = input.replaceAll("\\s+", "").split(","); // 공백 처리 완료

        Set<String> carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            validateCarNameLength(carName);
            carNamesSet.add(carName);
        }
        validateCarCount(carNamesSet);
        carNamesSet.forEach(System.out::println);
    }

    private static void validateCarNameLength(String input) {
        if (input.isEmpty() || input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarCount(Set<String> inputs) {
        if (inputs.size() < 2) {
            throw new IllegalArgumentException();
        }

    }

}
