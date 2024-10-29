package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class InputValidator {
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE = "시도 횟수는 숫자여야 한다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String CAR_NAME_MINIMUM_COUNT_ERROR_MESSAGE = "자동차 이름은 두개 이상이여야 합니다.";
    private static final String EMPTY_MESSAGE = "입력이 비었습니다.";

    private static final int CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_COUNTS = 2;

    public static void validateCarNameLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateAttemptCountIsNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateCarCounts(List<Car> carList) {
        if (carList.size() < MINIMUM_CAR_COUNTS) {
            throw new IllegalArgumentException(CAR_NAME_MINIMUM_COUNT_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateCarName(List<Car> carList, Car input) {
        if (carList.contains(input)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

