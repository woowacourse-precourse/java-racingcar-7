package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String NAME_PATTERN = "^[a-zA-Z]+(,[a-zA-Z]+)*$";

    private InputValidator() {
    }

    public static void nameValidator(String input) {
        if (!input.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("구분자를 확인해주세요.");
        }

        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void numberValidator(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수 입력이 잘못되었습니다.");
        }

        if (number <= 0) {
            throw new IllegalArgumentException("횟수는 0보다 큰 양수여야 합니다.");
        }
    }
}
