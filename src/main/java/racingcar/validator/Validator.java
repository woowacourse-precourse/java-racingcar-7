package racingcar.validator;

import java.util.List;

public class Validator {

    public static void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
            }
        }
    }

    public static void validateNameFormat(List<String> carNames) {
        for (String name : carNames) {
            if (!name.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳 문자만 포함해야 합니다: " + name);
            }
        }
    }

}
