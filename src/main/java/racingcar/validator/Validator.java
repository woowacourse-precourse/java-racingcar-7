package racingcar.validator;

public class Validator {
    public static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("사용할 수 있는 이름이 없습니다.");
        }
    }
}
