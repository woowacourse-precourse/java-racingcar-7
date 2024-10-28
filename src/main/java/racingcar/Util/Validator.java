package racingcar.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void carName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자 까지 입력 가능합니다.");
        }
    }

    public static void trialCount(String count) {
        try {
            int trialCount = Integer.parseInt(count);
            if (trialCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상 이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 이동 횟수를 입력하셨습니다.");
        }
    }

    public static void duplicationName(List<String> names) {
        Set<String> duplicationName = new HashSet<>(names);
        if (duplicationName.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복 되었습니다.");
        }
    }
}
