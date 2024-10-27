package racingcar.validator;

public class TrialCountValidator {

    private TrialCountValidator() {
    }

    public static void validateTrialCount(String input) {
        validateNotBlank(input);
        validateNumeric(input);
    }

    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    static void validateNumeric(String input) {
        String regex = "^[1-9]\\d*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다.");
        }
    }

}
