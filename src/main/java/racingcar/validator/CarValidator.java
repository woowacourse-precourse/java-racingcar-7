package racingcar.validator;

import java.util.Arrays;

public class CarValidator {
    public static boolean isValid(String carNames) throws IllegalArgumentException {
        if(isNull(carNames)) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");

        carNames = carNames.trim();

        if(isEmpty(carNames)) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        if(hasInvalidCharacters(carNames)) throw new IllegalArgumentException("특수문자는 입력할 수 없습니다.");
        if(hasExceedMaxLength(carNames)) throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");

        return true;
    }

    private static boolean hasExceedMaxLength(String carNames) {
        return Arrays.stream(carNames.split(","))
                .anyMatch(carName -> carName.length() > 5);
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
