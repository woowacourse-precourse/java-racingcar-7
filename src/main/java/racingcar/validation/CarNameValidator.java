package racingcar.validation;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static String validate(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상, 5글자 이하여야 합니다.");
        }

        return carName;
    }
}
