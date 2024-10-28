package racingcar;

import java.util.*;

public class CarList {
    public static List<String> carList(String input) {
        // 이름을 리스트로 변환
        List<String> nameList = new ArrayList<>(Arrays.asList(input.trim().split("\\s*,\\s*")));
        Set<String> uniqueNames = new HashSet<>();

        // 각 이름에 대한 검증
        for (String name : nameList) {

            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름 중 공백이 존재합니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘길 수 없습니다.");
            }

            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름 중 중복된 이름이 있습니다: " + name);
            }

        }

        return nameList;
    }
}
