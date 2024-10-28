package racingcar.validator;

import java.util.regex.Pattern;
import racingcar.exception.MoveCountException;

public class MoveCountValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    public static final String ATTEMPTS_EMPTY_ERROR = "이동횟수를 입력해주세요.";
    public static final String ATTEMPTS_ZERO_ERROR = "이동횟수는 1번 이상이어야합니다.";
    public static final String ATTEMPTS_NEGATIVE_ERROR = "이동횟수는 음수가 될 수 없습니다.";
    public static final String ATTEMPTS_NUMBER_ERROR = "이동횟수는 숫자로만 입력가능합니다.";

    public static void validate(String inputNum) {
        if (inputNum == null || inputNum.isBlank()) {
            throw new MoveCountException(ATTEMPTS_EMPTY_ERROR);
        }
        if (inputNum.equals("0")) {
            throw new MoveCountException(ATTEMPTS_ZERO_ERROR);
        }
        if (inputNum.contains("-")) {
            throw new MoveCountException(ATTEMPTS_NEGATIVE_ERROR);
        }
        if (!NUMBER_PATTERN.matcher(inputNum).matches()) {
            throw new MoveCountException(ATTEMPTS_NUMBER_ERROR);
        }
    }
}
