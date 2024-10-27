package racingcar.global;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static List<String> convertInputToCarNames(String input) {
        List<String> carNames = new ArrayList<>();
        for (String carName : input.split(",")) {
            String name = carName.trim();
            checkNameLength(name);
            carNames.add(carName.trim());
        }
        return carNames;
    }

    public static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static int convertInputToInteger(String input) throws IllegalArgumentException {
        int totalAttempt = Integer.parseInt(input);
        if (!isPositive(totalAttempt)) {
            throw new IllegalArgumentException();
        }
        return totalAttempt;
    }

    public static boolean isPositive(int value) {
        return value > 0;
    }
}
