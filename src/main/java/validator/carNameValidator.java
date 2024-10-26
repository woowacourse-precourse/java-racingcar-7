package validator;

import java.util.List;

public class carNameValidator {

    public static void isValid(List<String> carNames) {
        for (String name : carNames) {
            validateSingleCarName(name);
        }

    }

    public static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상이어야 합니다.");
        }


    }

    public static void validateSingleCarName(String carName) {
        checkEmpty(carName);
        checkCarNameLength(carName);
    }

    private static void checkCarNameLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다: " + input);
        }
    }

}
