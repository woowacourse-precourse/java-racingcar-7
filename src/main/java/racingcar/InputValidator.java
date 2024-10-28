package racingcar;

import java.util.regex.Pattern;

public class InputValidator extends BaseValidator {
    private static final String PLAYER_NAMES_FORMAT = "^[a-zA-Z0-9, ]+$";
    private static final String NUMBER_FORMAT = "^[1-9][0-9]*$";
    private static final Pattern PLAYER_NAMES_PATTERN = Pattern.compile(PLAYER_NAMES_FORMAT);
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_FORMAT);

    public static void validatePlayerNames(final String rawName) {
        validateNotNullOrEmpty(rawName, "자동차 이름을 입력해야 합니다.");
        validatePattern(rawName, PLAYER_NAMES_PATTERN, "자동차 이름은 알파벳, 숫자, 쉼표만 사용할 수 있으며 빈 값은 허용되지 않습니다.");
    }

    public static void validateRaceCount(final String count) {
        validateNotNullOrEmpty(count, "시도 횟수는 필수 입력값입니다.");
        validatePattern(count, NUMBER_PATTERN, "시도 횟수는 1 이상의 숫자여야 합니다.");
    }
}
