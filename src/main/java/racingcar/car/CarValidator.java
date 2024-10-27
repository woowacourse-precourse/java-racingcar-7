package racingcar.car;

public class CarValidator {

    private static final int MAX_CAR_NAME = 5;

    public static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
        }
    }
}
