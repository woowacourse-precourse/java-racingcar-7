package racingcar.util;

import java.util.Arrays;

import static racingcar.util.Constants.*;

public class CarNameValidator {
    public static final int NAME_SIZE = 5;
    private static final String DELIMITER = ",";

    public String[] nameList = new String[0];

    public String[] validate(String[] carNames) {
        nameList = carNames;
        isNotDuplicate();
        isRightNameSize();
        hasEmptyName();
        return nameList;
    }

    public void isRightNameSize() {
        if (Arrays.stream(nameList).anyMatch(name -> name.length() > NAME_SIZE)) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_ERROR.getMessage());
        }
    }

    public void isNotDuplicate() {
        if (Arrays.stream(nameList).distinct().count() != nameList.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }

    public void hasEmptyName() {
        if (Arrays.stream(nameList).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR.getMessage());
        }
    }
}
