package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void carNames(List<String> carNames) {
        nullNames(carNames);
        blankNames(carNames);
        nameLength(carNames);
        uniqueNames(carNames);
    }

    public static int trialCount(String input) {
        try {
            int trialCount = Integer.parseInt(input); // String을 int로 변환

            if (trialCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 양수여야 합니다.");
            }

            return trialCount; // 유효한 경우 trialCount를 반환

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 숫자를 입력해주세요."); // 숫자가 아닐 경우
        }
    }


    public static void nullNames(List<String> carNames) {
        for (String name : carNames) {
            if (name == null) {
                throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
            }
        }
    }

    public static void blankNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }

    public static void nameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
            }
        }
    }

    public static void uniqueNames(List<String> carNames) {
        Set<String> namesSet = new HashSet<>();
        for (String name : carNames) {
            if (!namesSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
