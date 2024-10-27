package racingcar.validator;

import java.util.List;

public class Validator {
    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("사용할 수 있는 이름이 없습니다.");
        }
    }

    public static void validateEachCarNames(List<String> carList) {
        for (String carName : carList) {
            validateName(carName);
        }
    }

    private static void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("입력된 이름 중 길이가 5자를 초과한 이름이 있습니다.");
        }
    }

    public static void validateIsNumeric(String input) {
        if (input == null || !input.matches("\\d+")) {
            throw new IllegalArgumentException("Rounds 수에는 숫자만 허용됩니다.");
        }
    }

    public static void validateTryRounds(Integer input) {
        if (input < 1) {
            throw new IllegalArgumentException("Rounds 수는 1 이상이여야 합니다.");
        }
    }
}
