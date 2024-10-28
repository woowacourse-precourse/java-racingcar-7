package racingcar;

import java.util.Collections;
import java.util.List;

public class Validator {
    public static int InputNumValidator(String intInput) {
        if (intInput.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }

        int number;

        try {
            number = Integer.parseInt(intInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }

        return number;
    }

    public static List<String> InputStringValidator(String input, List<String> carsList) {
        String pattern = "[^a-zA-Z가-힣]";

        if (input.matches(".*" + pattern + ".*")) {
            if (!input.matches(",")) {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
        }

        for (String car : carsList) {
            if (car.trim().isEmpty()) {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
            if (Collections.frequency(carsList, car) > 1) {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
        }

        return carsList;
    }
}
