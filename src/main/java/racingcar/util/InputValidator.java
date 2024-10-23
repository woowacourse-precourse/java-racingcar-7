package racingcar.util;

import java.util.List;

public class InputValidator {

    public static void validateCarNames(final List<String> carNames) {
        for(final String name : carNames){
            if(name.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다: " + name);
            }
        }
    }

    public static int validateAndParseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }
}
