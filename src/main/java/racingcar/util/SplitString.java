package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class SplitString {
    private static final String CAR_NAME_REGEX = "^[0-9a-zA-Z가-힣]+$";

    private SplitString() {
    }

    public static List<String> SplitCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .filter(SplitString::checkCarNameLength)
                .toList();
    }

    private static boolean checkCarNameLength(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백 혹은 빈 문자열은 허용되지 않습니다");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다. ");
        }

        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 한글, 영어, 숫자로만 구성될 수 있습니다");
        }

        return true;
    }
}
