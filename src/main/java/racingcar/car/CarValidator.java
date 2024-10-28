package racingcar.car;

public abstract class CarValidator {
    private static final int LIMIT_NAME_LENGTH = 5;
    public static void valid(Car car) {
        validName(LIMIT_NAME_LENGTH, car.getName());
    }

    public static void validName(int limitLength, String carName) {
        if (carName.isBlank() || carName.isEmpty() || carName.length() > limitLength) {
            throw new IllegalArgumentException("자동차의 이름이 올바르지 않습니다!");
        }
    }
}
