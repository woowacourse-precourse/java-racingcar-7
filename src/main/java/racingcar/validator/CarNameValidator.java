package racingcar.validator;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateLength(String name) {
        if (!isValidLength(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이내여야 합니다.");
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() <= MAX_CAR_NAME_LENGTH;
    }
}
