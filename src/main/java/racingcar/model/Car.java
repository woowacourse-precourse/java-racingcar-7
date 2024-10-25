package racingcar.model;

public class Car {

    private final String name;
    private int winStack;

    public Car(String name) {
        CarNameLengthLimitValidator(name);
        this.name = name;
        this.winStack = 0;
    }

    private static void CarNameLengthLimitValidator(String name) {
        final int CAR_NAME_LENGTH_LIMIT = 5;
        final String CAR_NAME_LENGTH_LIMIT_VALIDATION = "자동차 이름은 5자 이하여야 합니다.";
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_VALIDATION);
        }
    }
}
