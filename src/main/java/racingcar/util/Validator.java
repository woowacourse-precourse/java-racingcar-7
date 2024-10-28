package racingcar.util;

import java.util.HashSet;

public class Validator {
    static void validateWhitespaceInput(String input) {
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException("입력값은 공백으로 시작하거나 끝날수 없습니다.");
        }
    }

    static void validateNullInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열이 될수없습니다.");
        }
    }

    static void validateCarName(String name) {
        validateNullInput(name);
        validateWhitespaceInput(name);
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 입력할수있습니다.");
        }
    }

    static void validateUniqueCarName(String[] carNames) {
        HashSet<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            String lowerCaseCarName = name.toLowerCase();
            if (!nameSet.add(lowerCaseCarName)) {
                throw new IllegalArgumentException("중복된 차 이름을 넣을 수 없습니다.");
            }
        }
    }

    static int validatePositiveNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num <= 0) {
                throw new IllegalArgumentException("양수인 숫자만 입력가능합니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할수없습니다.");
        }
    }
}
