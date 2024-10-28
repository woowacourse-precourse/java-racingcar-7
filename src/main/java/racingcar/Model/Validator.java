package racingcar.Model;

import java.util.List;
import racingcar.Constants.ErrorMessage;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_ROUND_RANGE = 10000;

    public static void inputCarNames(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY);
        }
    }

    public static void inputRound(String input) {
        checkDigit(input);
        checkInteger(input);
    }

    private static void checkDigit(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_FORMAT);
        }
    }

    private static void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_RANGE);
        }
    }

    public static void round(int round) {
        checkRange(round);
    }

    private static void checkRange(int round) {
        if (!(0 < round && round <= MAX_ROUND_RANGE)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_RANGE);
        }
    }

    public static void carList(List<Car> carList) {
        namesUnique(carList);
        namesLength(carList);
        namesNotBlank(carList);
    }

    private static void namesUnique(List<Car> carList) {
        long uniqueCount = carList.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCount != carList.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_UNIQUE_NAME);
        }
    }

    private static void namesLength(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_LENGTH);
            }
        }
    }

    private static void namesNotBlank(List<Car> carList) {
        for (Car car : carList) {
            if (car.getName().isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_EMPTY);
            }
        }
    }

}
