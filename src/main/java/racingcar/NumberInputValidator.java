package racingcar;

public class NumberInputValidator {

    public static void validate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수 입력이 올바르지 않습니다");
        }
    }
}
