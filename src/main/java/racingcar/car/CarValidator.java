package racingcar.car;

public class CarValidator {

    private static final int MAX_CAR_NAME = 5;

    public static void carNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
        }
    }

    public static void carNameEmpty(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름으로 공백은 불가능합니다.");
        }
    }
}
