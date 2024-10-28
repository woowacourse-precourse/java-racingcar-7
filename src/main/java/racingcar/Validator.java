package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MIN_ATTEMPTS = 1;
    private static final String ERROR_EMPTY_INPUT = "경주할 자동차가 없습니다.";
    private static final String ERROR_MINIMUM_CARS = "경주할 자동차는 최소 2대 이상이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAMES = "자동차 이름이 중복되었습니다.";
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 1자 이상, 5자 이하만 가능합니다.";
    private static final String ERROR_NON_NUMERIC_ATTEMPTS = "시도 횟수는 숫자여야 합니다.";
    private static final String ERROR_INVALID_ATTEMPTS = "시도 횟수는 1이상 이어야합니다.";


    public static List<String> validateInput(String input) {
        checkIfInputIsEmpty(input);
        List<String> inputList = splitInput(input);
        checkDuplicateNames(inputList);
        checkNameLength(inputList);
        return inputList;
    }

    private static void checkIfInputIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private static List<String> splitInput(String input) {
        List<String> inputList = List.of(input.split(","));
        if (inputList.size() < 2) {
            throw new IllegalArgumentException(ERROR_MINIMUM_CARS);
        }
        return inputList;
    }

    private static void checkDuplicateNames(List<String> inputList) {
        Set<String> set = new HashSet<>(inputList);
        if (inputList.size() != set.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
        }
    }

    private static void checkNameLength(List<String> inputList) {
        inputList.forEach(name -> {
            name = name.trim();
            if (name.isEmpty() || name.length() > Car.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        });
    }

    public static int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_ATTEMPTS);
        }
    }

    public static void checkAttempts(int attempts) {
        if (attempts < MIN_ATTEMPTS) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPTS);
        }
    }


}
