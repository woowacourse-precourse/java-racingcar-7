package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void carNames(List<String> carNames) {
        nameLength(carNames);
        uniqueNames(carNames);
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
