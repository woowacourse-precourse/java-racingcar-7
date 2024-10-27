package racingcar;

import java.util.LinkedHashMap;

public class Validator {
    private static final int MAX_LENGTH = 5;

    private enum ErrorMessage {
        MUST_BE_5_CHARACTERS_OR_LESS("자동차 이름이 5글자 이하여야 합니다."),
        MUST_BE_UNIQUE("자동차 이름이 중복되지 않아야 합니다."),
        MUST_BE_FILLED("자동차 이름이 공백이지 않아야 합니다."),
        MUST_BE_NUMBER("시도할 횟수가 숫자여야 합니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void validateCarName(LinkedHashMap<String, Integer> carPositions, String carName) {
        validateFilled(carName);
        validateLength(carName);
        validateUnique(carPositions, carName);
    }

    public static void validateMaxTurn(String maxTurn) {
        validateIsNumber(maxTurn);
    }

    private static void validateUnique(LinkedHashMap<String, Integer> carPositions, String carName) {
        if (carPositions.containsKey(carName)) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_UNIQUE.getMessage());
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_5_CHARACTERS_OR_LESS.getMessage());
        }
    }

    private static void validateFilled(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_FILLED.getMessage());
        }
    }

    private static void validateIsNumber(String maxTurn) {
        try {
            Integer.parseInt(maxTurn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage());
        }
    }
}
