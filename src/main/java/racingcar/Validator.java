package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static List<String> checkInputCarNames(String input) {
        List<String> result = new ArrayList<>();

        if (input == null) {
            input = "";
        }

        Arrays.stream(input.split(","))
                .forEach(s -> {
                    s = s.trim();
                    if (s.isEmpty() || s.length() > 5) {
                        throw new IllegalArgumentException("자동차 이름을 입력해주세요");
                    } else {
                        result.add(s);
                    }
                });

        return result;
    }

    public static Integer checkInputRound(String input) {
        if (input == null) {
            input = "";
        } else {
            input = input.trim();
        }

        if (input.isEmpty() || !input.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입니다");
        }

        return Integer.parseInt(input);
    }
}
