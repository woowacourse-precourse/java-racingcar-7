package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingCarInputConverter {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INTEGER_REGEX = "\\d+";
    private static final String SEPARATOR = ",";

    public List<String> getUserCarName(String names) {
        if (isValidString(names)) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }

        return Arrays.stream(names.split(SEPARATOR))
                .map(String::trim)
                .peek(name -> {
                    if (name.length() > MAX_CAR_NAME_LENGTH) {
                        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
                    }
                })
                .toList();
    }

    public int getUserCarNumber(String number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(number);
    }

    private static boolean isInvalidNumber(String number) {
        return number.isEmpty() || !number.matches(INTEGER_REGEX);
    }

    private static boolean isValidString(String names) {
        return names == null || names.isEmpty();
    }

}
