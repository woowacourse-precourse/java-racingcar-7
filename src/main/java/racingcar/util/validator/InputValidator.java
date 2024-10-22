package racingcar.util.validator;

import java.util.HashSet;

public class InputValidator {

    private static final String CAR_NAMES_REGEX = "[가-힣|a-zA-Z]{1,5}(,[가-힣|a-zA-Z]{1,5})*";

    public static void validateCarNames(String input) {
        checkInputForm(input);
        checkDuplicate(input);
    }

    private static void checkInputForm(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름을 입력해주세요");
        }
    }

    private static void checkDuplicate(String input) {
        String[] names = input.split(",");
        HashSet<String> carNames  = new HashSet<>();
        for (String name : names) {
            if (!carNames.add(name)) {
                throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 입력하셨습니다.");
            }
        }
    }
}
