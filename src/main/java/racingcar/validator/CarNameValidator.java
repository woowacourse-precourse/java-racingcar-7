package racingcar.validator;

public class CarNameValidator {
    public static void validate(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해주세요.");
        }
    }
}
