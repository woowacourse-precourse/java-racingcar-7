package racingcar.controller.validator;

import java.util.List;

public class Validator {

    private Validator() {
    }

    public static void validateNameList(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하이여야 합니다.");
            }
        }
    }

    public static void validateTimeInput(long times) {
        if (times < 0) {
            throw new IllegalArgumentException("횟수는 0 이상이여야 합니다.");
        }
    }
}
