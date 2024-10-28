package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static ArrayList<String> parse(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("이름이 포함된 문자열을 입력하세요.");
        }

        if (!input.matches("^([a-zA-Z가-힣]{1,5})(,[a-zA-Z가-힣]{1,5})*$")) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }

        List<String> names = Arrays.asList(input.split(","));

        return new ArrayList<>(names);
    }
}