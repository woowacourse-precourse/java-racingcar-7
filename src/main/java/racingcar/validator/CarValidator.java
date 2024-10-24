package racingcar.validator;

import java.util.Arrays;

public class CarValidator {
    public static boolean isValid(String carNames) throws IllegalArgumentException {
        if(isNull(carNames)) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");

        carNames = carNames.trim();

        if(isEmpty(carNames)) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        if(hasInvalidCharacters(carNames)) throw new IllegalArgumentException("특수문자는 입력할 수 없습니다.");
        if(isCarNameInvalid(carNames)) throw new IllegalArgumentException("자동차 이름을 제대로 입력해야합니다.");

        return true;
    }

    private static boolean isCarNameInvalid(String carNames) {
        String[] carNamesArray = carNames.split(",");

        if (carNamesArray.length == 0) return true;

        return Arrays.stream(carNamesArray)
                .anyMatch(carName -> {
                    return carName.length() > 5 || carName.trim().isEmpty() || carName.trim().isBlank();
                });
    }

    private static boolean hasInvalidCharacters(String carNames) {
        return carNames.matches(".*[^a-zA-Z0-9,].*");
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

}
