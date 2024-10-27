package racingcar.utils;

import java.util.Map;

public class Validation {
    final static int CAR_NAME_LENGTH = 5;
    final static int MIN_TRY_NUMBER = 1;

    public static void inputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    public static void carNameLimit(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            if (car.length() > CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void tryNumberRange(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("시도 횟수는 양수만 가능합니다.");
        }
    }
}
