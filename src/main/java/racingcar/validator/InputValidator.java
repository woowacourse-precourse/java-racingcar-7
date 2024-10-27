package racingcar.validator;

public class InputValidator {

    public static void validateTryCount(String inputTryCount) {
        try {
            Long.valueOf(inputTryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 횟수는 아라비아 숫자로 입력해야 합니다");
        }
    }
}
