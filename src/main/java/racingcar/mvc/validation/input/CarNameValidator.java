package racingcar.mvc.validation.input;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {
    public static void isValid(String input) {
        isEmpty(input);

        List<String> names = new ArrayList<>();

        for (String s : input.split(",")) {
            s = s.trim();

            isEmpty(s);

            isValidLength(s);

            containsWhiteSpace(s);

            //특수문자

            isDuplicated(names, s);
        }
    }

    private static void isDuplicated(List<String> names, String input) {
        if (names.contains(input)) {
            throw new IllegalArgumentException(input + "은 이미 사용된 이름입니다.");
        }
    }

    private static void containsWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("이름은 공백을 가질 수 없습니다.");
        }
    }

    private static void isValidLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5 초과 입니다.");
        }
    }

    private static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }


}
