package racingcar.validator;

public class RoundValidator {
    public static void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("자연수가 아닌 값이 들어왔습니다.");
        }
    }
}
