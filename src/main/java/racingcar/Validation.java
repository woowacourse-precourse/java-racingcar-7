package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {
    private static final String CAR_NAME_INPUT_PATTERN = "[a-zA-Z0-9]{1,5}";

    public String[] validateCarName(String input) {
        if (!validateTheNumberOfCarNames(input)) {
            throw new IllegalArgumentException("최소 2개 이상의 자동차 이름을 입력해야 합니다.");
        }

        String[] splited = input.split(",");
        if (!validateCarNamesUniqueness(splited)) {
            throw new IllegalArgumentException("모든 자동차는 서로 다른 이름을 가져야 합니다.");
        }

        if (!validateEachCarName(splited)) {
            throw new IllegalArgumentException("자동차 이름은 알파벳 대소문자와 숫자로만 이루어져 있어야 하며, 1자 이상 5자 이하여야 합니다.");
        }

        return splited;
    }

    private boolean validateTheNumberOfCarNames(String input) {
        if (!input.contains(",")) {
            return false;
        }
        return true;
    }

    private boolean validateCarNamesUniqueness(String[] splited) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.stream(splited).toList());
        if (uniqueCarNames.size() == splited.length) {
            return true;
        }
        return false;
    }

    private boolean validateEachCarName(String[] splited) {
        for (String carName : splited) {
            if (!Pattern.matches(CAR_NAME_INPUT_PATTERN, carName)) {
                return false;
            }
        }
        return true;
    }

    public int validateRoundLimit(String input) {
        try {
            int limit = Integer.parseInt(input);
            if (limit <= 0 || limit > 100) {
                throw new IllegalArgumentException("입력된 수가 범위를 벗어납니다. 1번 이상, 100번 이하로만 시도 가능합니다.");
            }
            return limit;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 숫자 형태가 아닙니다.");
        }
    }
}
