package racingcar.utill;

import java.util.Objects;

public class InputValidator {

    private static final String INVALID_ROUNDS_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNames(String input) {
        String[] names = input.split(",");

        for (String name : names) {
            if (name.trim().isEmpty() || name.trim().length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
            }
        }
    }

    public static void validateRounds(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUNDS_ERROR_MESSAGE);
        }
    }
}
