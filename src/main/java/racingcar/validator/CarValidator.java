package racingcar.validator;

import java.util.regex.Pattern;

public class CarValidator extends BaseValidator {
    private static final String CAR_NAME_FORMAT = "^[a-zA-Z0-9]+$"; // 알파벳과 숫자만 허용
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile(CAR_NAME_FORMAT);

    public static void validateCarName(final String name) {
        validateNotNullOrEmpty(name, "자동차 이름은 필수 입력값입니다.");
        validatePattern(name, CAR_NAME_PATTERN, "자동차 이름은 알파벳과 숫자만 사용할 수 있습니다.");
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
