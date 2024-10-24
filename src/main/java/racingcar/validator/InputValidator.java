package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.constant.Constant;

public class InputValidator {
    private static final String CAR_NAME_INPUT_BLANK_MESSAGE = "경주할 자동차의 이름을 입력해 주세요.";
    private static final String CAR_NAME_BLANK_MESSAGE = "이름을 지정하지 않은 자동차가 있습니다.";
    private static final String CAR_NAME_TOO_LONG_MESSAGE = "자동차의 이름은 5자 이하로 설정해 주세요.";
    private static final String CAR_NAME_DUPLICATE_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    private static final String ROUND_COUNT_INPUT_BLANK_MESSAGE = "시도할 횟수를 입력해 주세요.";
    private static final String ROUND_COUNT_INVALID_MESSAGE = "양의 정수를 입력해 주세요.";

    public static Set<String> validateCarNameInput(String input) {
        validateCarNameInputBlank(input);

        String[] names = input.split(Constant.DELIMITER);
        Arrays.setAll(names, i -> names[i].trim());
        for (String name : names) {
            validateCarNameBlank(name);
            validateCarNameTooLong(name);
        }

        Set<String> cars = new HashSet<>(Arrays.asList(names));
        validateDuplicatedCarName(cars.size(), names.length);

        return cars;
    }

    private static void validateCarNameInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_BLANK_MESSAGE);
        }
    }

    private static void validateCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_MESSAGE);
        }
    }

    private static void validateCarNameTooLong(String name) {
        if (name.length() > Constant.CAR_NAME_LENGTH_CRITERIA) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG_MESSAGE);
        }
    }

    private static void validateDuplicatedCarName(int carSetCount, int inputCarCount) {
        if (carSetCount != inputCarCount) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_MESSAGE);
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_COUNT_INVALID_MESSAGE);
        }

        return roundCount;
    }
}
