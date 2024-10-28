package racingcar.util;

import static racingcar.message.exception.SplitStringExceptionMessage.CAR_NAME_INCLUDE_BLANK;
import static racingcar.message.exception.SplitStringExceptionMessage.CAR_NAME_INCLUDE_SPECIAL_CHARACTERS;
import static racingcar.message.exception.SplitStringExceptionMessage.CAR_NAME_LENGTH_OVER;

import java.util.Arrays;
import java.util.List;

public class SplitString {
    private static final String CAR_NAME_REGEX = "^[0-9a-zA-Z가-힣]+$";

    private SplitString() {
    }

    public static List<String> SplitCarNames(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        checkCarNameValid(carNameList);

        return carNameList;
    }

    private static void checkCarNameValid(List<String> carNameList) {
        checkCarNameList(carNameList);
        carNameList.forEach(SplitString::checkCarName);
    }

    private static void checkCarNameList(List<String> carNameList) {
        if (carNameList.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_INCLUDE_BLANK);
        }
    }

    private static void checkCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_INCLUDE_BLANK);
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }

        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(CAR_NAME_INCLUDE_SPECIAL_CHARACTERS);
        }
    }
}
