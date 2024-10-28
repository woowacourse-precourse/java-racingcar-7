package racingcar.validator;

public class RoundValidator {
    public static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
