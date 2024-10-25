package racingcar.util.validator;

import java.util.HashSet;

public class InputValidator {

    private static final String CAR_NAMES_REGEX = "[가-힣|a-zA-Z]{1,5}(,[가-힣|a-zA-Z]{1,5})*";
    private static final String NUMBER_OF_TRIAL_REGEX = "0|([1-9])([0-9])*";
    public static final String COMMA = ",";

    public static void validateCarNames(String input) {
        checkNull(input);
        checkInputForm(input);
        checkDuplicate(input);
    }

    private static void checkInputForm(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름을 입력해주세요");
        }
    }

    private static void checkDuplicate(String input) {
        String[] names = input.split(COMMA);
        HashSet<String> carNames  = new HashSet<>();
        for (String name : names) {
            if (!carNames.add(name)) {
                throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 입력하셨습니다.");
            }
        }
    }

    public static void validateNumberOfTrial(String numberOfTrial) {
        checkNull(numberOfTrial);
        checkNumberForm(numberOfTrial);
        checkNumberRange(numberOfTrial);
    }

    private static void checkNumberForm(String numberOfTrial) {
        if (!numberOfTrial.matches(NUMBER_OF_TRIAL_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요");
        }
    }

    private static void checkNumberRange(String numberOfTrial) {
        try {
            Integer.parseInt(numberOfTrial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수 범위를 초과했습니다.");
        }
    }

    private static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
    }
}
