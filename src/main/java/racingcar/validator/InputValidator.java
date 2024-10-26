package racingcar.validator;

import java.util.Arrays;
import racingcar.constant.Constant;
import racingcar.domain.car.CarNames;

public class InputValidator {
    private static final String CAR_NAME_INPUT_BLANK_MESSAGE = "경주할 자동차의 이름을 입력해 주세요.";
    private static final String ROUND_COUNT_INPUT_BLANK_MESSAGE = "시도할 횟수를 입력해 주세요.";
    private static final String ROUND_COUNT_INVALID_MESSAGE = "양의 정수를 입력해 주세요.";

    public static CarNames validateCarNameInput(String input) {
        validateCarNameInputBlank(input);
        String[] names = splitCarNameInput(input);
        return new CarNames(Arrays.asList(names));
    }

    private static String[] splitCarNameInput(String input) {
        String[] names = input.split(Constant.DELIMITER);
        Arrays.setAll(names, i -> names[i].trim());
        return names;
    }

    private static void validateCarNameInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_BLANK_MESSAGE);
        }
    }

    public static int validateRoundCountInput(String input) {
        validateRoundCountInputBlank(input);
        return validateRoundCount(input);
    }

    private static void validateRoundCountInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ROUND_COUNT_INPUT_BLANK_MESSAGE);
        }
    }

    private static int validateRoundCount(String input) {
        int roundCount;

        try {
            roundCount = Integer.parseInt(input);
            validateRoundCountNegative(roundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_COUNT_INVALID_MESSAGE);
        }

        return roundCount;
    }

    private static void validateRoundCountNegative(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException(ROUND_COUNT_INVALID_MESSAGE);
        }
    }
}
