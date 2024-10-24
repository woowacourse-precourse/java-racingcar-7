package racingcar.service.validation;

public class TimesValidation {

    public static void validateEmpty(final String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 입력되지 않았습니다");
        }
    }

    public static void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 입력되지 않았습니다");
        }
    }
    public static void validateCharacter(final String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException("[ERROR] 구분자를 제외한 입력은 숫자만 입력해 주세요.");
        }
    }

    public static void validateZeroOrNegative(final int times) {
        if (times <= 0){
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 0이거나 음수일 수 없습니다");
        }
    }

    private static boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

}

