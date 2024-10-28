package racingcar;

import java.util.regex.Pattern;

public class Validation {
    private static final String CAR_NAME_INPUT_PATTERN = "[a-zA-Z0-9]{1,5}";

    public String[] validateCarName(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("최소 2개 이상의 자동차 이름을 입력해야 합니다.");
        }
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (!Pattern.matches(CAR_NAME_INPUT_PATTERN, carName)) {
                throw new IllegalArgumentException("자동차 이름은 알파벳 대소문자와 숫자로만 이루어져 있어야 하며, 1자 이상 5자 이하여야 합니다.");
            }
        }
        return carNames;
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