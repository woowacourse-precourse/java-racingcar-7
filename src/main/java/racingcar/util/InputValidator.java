package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public void carNamesParser(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == ',') {
            throw new IllegalArgumentException("쉼표(,) 구분자 이후 이름이 등장하지 않았습니다.");
        }
        char[] chars = carNames.toCharArray();
        int sequence = 1;
        boolean nextIsName = false;
        for (char c : chars) {
            if (c == ' ') {
                throw new IllegalArgumentException("공백은 이름에 포함될 수 없습니다.");
            }
            if (sequence > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (nextIsName && c == ',') {
                throw new IllegalArgumentException("쉼표(,)가 연속으로 나올 수 없습니다.");
            }
            if (c == ',') {
                nextIsName = true;
                sequence = 1;
            } else {
                if (nextIsName) {
                    nextIsName = false;
                }
                sequence++;
            }
        }
    }

    public void hasDuplications(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다");
            }
        }
    }

    public void validateEpoch(int epoch) {
        if (epoch < 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        } else if (epoch > 100000) {
            throw new IllegalArgumentException("시도 횟수는 100000번 이하로 가능합니다.");
        }
    }
}
