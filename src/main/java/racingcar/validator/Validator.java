package racingcar.validator;

public class Validator {
    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하입니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈문자열입니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }

    public static void validateTryNumber(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (Integer.parseInt(tryNumber) <= 0) {
            throw new IllegalArgumentException("양수의 숫자가 아닙니다.");
        }
    }
}
