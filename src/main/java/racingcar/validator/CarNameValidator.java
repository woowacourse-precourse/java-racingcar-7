package racingcar.validator;

public class CarNameValidator {

    public static void validateCarName(String carName) {
        validateMinNameLength(carName);
        validateMaxNameLength(carName);
    }

    private static void validateMaxNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private static void validateMinNameLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

}
