package racingcar.validator;

public class RoundValidator {

    public static boolean isValid(String input) throws IllegalArgumentException {

        if(isNullOrEmpty(input)) throw new IllegalArgumentException("횟수를 입력해야합니다.");
        if(!isNumber(input)) throw new IllegalArgumentException("숫자만 입력해야합니다.");
        if(!isLargerThanZero(input)) throw new IllegalArgumentException("횟수는 1회 이상이어야 합니다.");

        return true;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isNumber(String input) {
        return input.matches("^\\d+$");
    }

    private static boolean isLargerThanZero(String input) {
        return Integer.parseInt(input) > 0;
    }
}
