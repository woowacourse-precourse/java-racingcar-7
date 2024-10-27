package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static final int MAX_LENGTH = 5;

    public static void isInteger(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("이동 횟수가 올바르지 않습니다.");
        }
    }

    public static void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            checkLength(carName);
        }
    }

    private static void checkLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    public static void checkDuplicateForCarName(String[] carNames) {
        Set<String> nameSet = new HashSet<>();

        for (String name : carNames) {
            checkDuplicate(name, nameSet);
        }
    }

    private static void checkDuplicate(String name, Set<String> nameSet) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException("중복된 이름 발견: " + name);
        }
    }
}
