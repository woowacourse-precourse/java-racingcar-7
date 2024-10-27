package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ROUND_INPUT_NEGATIVE_ERROR = "0보다 큰 수를 입력해주세요.";
    private static final String INTEGER_RANGE_ERROR = "2,147,483,647 이하의 양수를 입력해주세요.";
    private static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 5자 이하로 작성해주세요.";
    private static final String CAR_NAME_DUPLICATE_ERROR = "중복된 자동차 이름입니다.";

    private static Set<String> carNameSet;

    public static void validateCarNames(String carName) {
        carNameSet = new HashSet<>();
        validateLength(carName);
        validateDuplicates(carName);

        carNameSet.add(carName);
    }

    public static int validateRounds(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds < 1) {
                throw new IllegalArgumentException(ROUND_INPUT_NEGATIVE_ERROR);
            }

            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_RANGE_ERROR);
        }
    }

    private static void validateLength(String carName) {
        if (carName.trim().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateDuplicates(String carName) {
        if (carNameSet.contains(carName)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
    }
}
