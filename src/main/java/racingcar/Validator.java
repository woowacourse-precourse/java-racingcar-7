package racingcar;

import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE_INPUT_EMPTY = "자동차 이름을 입력해주세요.";
    private static final String ERROR_MESSAGE_ROUND_FORMAT = "시도 횟수는 정수만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_ROUND_RANGE = "시도 횟수는 양의 정수만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_UNIQUE_NAME = "자동차 이름은 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다";
    private static final String ERROR_MESSAGE_NAME_EMPTY = "자동차 이름은 공백이 불가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public static void inputSting(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_EMPTY);
        }
    }

    public static void checkRound(String input) {
        inputRoundDigit(input);
        roundRange(Integer.parseInt(input));
    }

    private static void inputRoundDigit(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_FORMAT);
        }
    }

    private static void roundRange(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_RANGE);
        }
    }

    public static void carList(List<Car> carList) {
        carNamesUnique(carList);
        carNamesLength(carList);
        carNamesBlank(carList);
    }

    private static void carNamesUnique(List<Car> carList) {
        long uniqueCount = carList.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCount != carList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIQUE_NAME);
        }
    }

    private static void carNamesLength(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
            }
        }
    }

    private static void carNamesBlank(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().isBlank()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NAME_EMPTY);
            }
        }
    }

}
