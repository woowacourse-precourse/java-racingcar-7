package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        if (carNames.size()<2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }

    }

    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해 주세요");
        }
        if(Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
