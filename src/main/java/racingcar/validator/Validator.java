package racingcar.validator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> checkName(String names) {
        List<String> cars = new ArrayList<>();

        isNull(names);
        endsWithComma(names);

        for (final String s : names.split(",")) {
            nameLength(s);
            cars.add(s);
        }
        return cars;
    }

    public static int checkCount(String num) {
        isNull(num);
        isNumber(num);

        int count = Integer.parseInt(num);

        return count;
    }

    private static void endsWithComma(String names) {
        if (names.endsWith(",")) {
            throw new IllegalArgumentException("마지막 입력이 구분자입니다.");
        }
    }

    private static void isNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자를 입력했습니다.");
        }
    }

    private static void nameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static void isNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("경기 횟수는 양수로 입력되어야 합니다.");
        }
    }
}
