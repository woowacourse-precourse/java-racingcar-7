package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    // 자동차 이름 유효성 검증
    /*public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] names = carNames.split(",");
        Set<String> nameSet = new HashSet<>();

        for (String name : names) {
            name = name.trim();
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (name.isEmpty() || !name.matches("[a-zA-Z가-힣]+")) {
                throw new IllegalArgumentException("자동차 이름은 공백이나 특수문자를 포함할 수 없습니다. (영어, 한글만)");
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
            }
        }
    }

    // 시도 횟수 유효성 검증
    public static void validateTrialCount(int trialCount) {
        if (trialCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }*/
}
