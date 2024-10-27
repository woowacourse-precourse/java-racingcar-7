package racingcar.util;

import static racingcar.message.SplitStringExceptionMessage.CAR_NAME_INCLUDE_BLANK;
import static racingcar.message.SplitStringExceptionMessage.CAR_NAME_INCLUDE_SPECIAL_CHARACTERS;
import static racingcar.message.SplitStringExceptionMessage.CAR_NAME_LENGTH_OVER;

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
            throw new IllegalArgumentException(CAR_NAME_INCLUDE_BLANK);
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }

        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(CAR_NAME_INCLUDE_SPECIAL_CHARACTERS);
        }

        return true;
    }
}
