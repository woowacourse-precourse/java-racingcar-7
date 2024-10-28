package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public static void validateCars(String[] cars) {
        Set<String> uniqueNames = new HashSet<>();
        if (cars.length <= 1) {
            throw new IllegalArgumentException("자동차는 최소 2대이상 입력해야합니다.");
        }
        for (String name : cars) {
            validateCarName(name, uniqueNames);
        }
    }

    private static void validateCarName(String name, Set<String> uniqueNames) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (!CAR_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("자동차 이름은 영문자와 숫자만 포함해야 합니다.");
        }
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static int validateAttemptsInput(String input) {
        try {
            int attempts = Integer.parseInt(input);
            validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해야 합니다.");
        }
    }

    public static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수를 입력해주세요");
        }
    }

}
