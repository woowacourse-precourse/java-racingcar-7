package validator;

import java.util.List;

public class CarValidator {
    private CarValidator() {}

    public static void isNameLengthExceed(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static void isNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public static void checkMinimumCarCount(List<String> carsNameList) {
        if (carsNameList.size() < 2) {
            throw new IllegalArgumentException("경주할 자동차 수가 부족합니다.");
        }
    }

    public static void checkNoDuplicateNames(List<String> carsNameList) {
        if (carsNameList.size() != carsNameList.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }
}
