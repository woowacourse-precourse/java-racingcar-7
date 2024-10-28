package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Utils {
    static String[] getNamesFromString(String names) {
        Set<String> uniqueCheck = new HashSet<>();
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수 입력값입니다. ");
        }
        names = names.replaceAll(" ", "");
        String[] nameArray = names.split(",");

        if (nameArray.length <= 1) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }

        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
            }
            if (uniqueCheck.contains(name)) {
                throw new IllegalArgumentException("중복된 이름의 자동차가 있습니다. ");
            }
            uniqueCheck.add(name);
        }
        return nameArray;
    }

    static int getTryCountFromString(String count) {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수 입니다.");
        }
        try {
            return Integer.parseInt(count); // 정수와 실수 모두 처리
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자 형태의 입력만 가능합니다. ");
        }
    }
}
