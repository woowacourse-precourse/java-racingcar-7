package racingcar;

import java.util.List;

public class Validator {
    public static void validateNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 입력할 수 없습니다.");
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 글자를 넘을 수 없습니다.");
        }
    }

    public static void validateNameDuplicate(String name, List<String> nameList) {
        if (nameList.contains(name)) {
            throw new IllegalArgumentException();
        }
    }
}
