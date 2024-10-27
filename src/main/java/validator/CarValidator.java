package validator;

import constant.ErrorCode;
import constant.Race;
import java.util.List;

public class CarValidator {
    private CarValidator() {}

    public static void isNameLengthExceed(String name) {
        if (name.length() > Race.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_LENGTH_EXCEED.getMessage());
        }
    }

    public static void isNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_NOT_EMPTY.getMessage());
        }
    }

    public static void checkMinimumCarCount(List<String> carsNameList) {
        if (carsNameList.size() < Race.MIN_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_CAR_COUNT.getMessage());
        }
    }

    public static void checkNoDuplicateNames(List<String> carsNameList) {
        if (carsNameList.size() != carsNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
