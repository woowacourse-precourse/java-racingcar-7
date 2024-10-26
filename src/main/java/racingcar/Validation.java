package racingcar;

import java.util.List;

public class Validation {

    public static String inputValidate(String string) {
        string = string.trim();
        if (string.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다. ");
        }
        return string;
    }

    public static void inputLastIndexValidate(String string) {
        if (string.endsWith(",")) {
            throw new IllegalArgumentException("문자열의 끝에 구분자가 위치해있습니다.");
        }
    }

    public static void nameLengthValidate(String string) {
        if (string.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 최대 5자까지 허용됩니다. ");
        }
    }

    public static void nameDuplicateValidate(String string, List<String> list) {
        if (list.contains(string)) {
            throw new IllegalArgumentException("자동차의 이름이 중복되었습니다. ");
        }
    }

    public static void tooManyCarsValidate(List<String> list) {
        if (list.size() > 10) {
            throw new IllegalArgumentException("자동차는 10대까지 허용됩니다. ");
        }
    }

    public static void tooManyMovesValidate(int move) {
        if (move > 10) {
            throw new IllegalArgumentException("이동 횟수는 10회까지 허용됩니다. ");
        }
    }

    public static void moveValidate(int move) {
        if (move < 1) {
            throw new IllegalArgumentException("1회 이상 이동해야합니다. ");
        }
    }

}
