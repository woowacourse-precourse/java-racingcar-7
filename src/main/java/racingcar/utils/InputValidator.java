package racingcar.utils;

public class InputValidator {
    private static final String NAME_PATTERN = "^[a-zA-Z]+(,[a-zA-Z]+)*$";

    public static void nameValidator(String input) {
        if (!input.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("이름 입력이 잘못되었습니다.");
        }
    }


}
