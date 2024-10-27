package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 공백 혹은 빈 문자열입니다.");
        }
    }

    public void validateCarNames(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        if (Arrays.stream(carNames).findAny().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백 혹은 빈 문자열입니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (!nameSet.add(carName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되면 안됩니다.");
            }

            if (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되면 안됩니다.");
            }
        }
    }

    public void validateTryNum(String tryNum) {
        try {
            int number = Integer.parseInt(tryNum);

            if (number < 0) {
                throw new IllegalArgumentException("시도 횟수가 음수이면 안됩니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
