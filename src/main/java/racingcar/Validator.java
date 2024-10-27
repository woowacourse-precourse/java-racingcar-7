package racingcar;

import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE_INPUT_EMPTY = "자동차 이름을 입력해주세요.";
    private static final String ERROR_MESSAGE_ROUND_FORMAT = "숫자만 입력 가능해요.";
    private static final String ERROR_MESSAGE_ROUND_RANGE = "자연수만 입력 가능해요";
    private static final String ERROR_MESSAGE_UNIQUE_NAME = "자동차 이름은 중복될 수 없어요.";
    private static final String ERROR_MESSAGE_NAME_LENGTH = "자동차 이름은 5자 이하만 가능해요.";
    private static final String ERROR_MESSAGE_NAME_EMPTY = "자동차 이름은 공백이 불가능해요.";


    public static void inputSting(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_EMPTY);
        }
    }

    public static void checkRound(String input) {
        int round;

        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_FORMAT);
        }
        if (round <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_RANGE);
        }
    }

    public static void carList(List<Car> carList) {
        carNamesUnique(carList);
        carNamesLength(carList);
        carNamesBlank(carList);
    }

    public static void carNamesUnique(List<Car> carList) {
        long uniqueCount = carList.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCount != carList.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIQUE_NAME);
        }
    }

    public static void carNamesLength(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > carList.size()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
            }
        }
    }

    public static void carNamesBlank(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().isBlank()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NAME_EMPTY);
            }
        }
    }


}
