package racingcar.validator;

import java.util.HashSet;

public class CarNameValidator {

    public static void checkValidNames(String[] names) throws Exception {
        checkNameLength(names);
        checkDuplicatedNames(names);
    }

    private static void checkNameLength(String[] names) throws Exception {
        for (String name : names) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new Exception("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
            }
        }
    }

    private static void checkDuplicatedNames(String[] names) throws Exception {
        HashSet<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new Exception("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

}
