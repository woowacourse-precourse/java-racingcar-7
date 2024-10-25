package racingcar.model;

public class Car {

    private final String name;
    private int winStack;

    public Car(String name) {
        CarNameEmptyValidator(name);
        CarNameLengthLimitValidator(name);
        this.name = name;
        this.winStack = 0;
    }

    private static void CarNameEmptyValidator(String name) {
        final String CAR_NAME_EMPTY_VALIDATION_MESSAGE = "자동차에 이름을 부여하지 않았습니다.";
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void CarNameLengthLimitValidator(String name) {
        final int CAR_NAME_LENGTH_LIMIT = 5;
        final String CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE= "자동차 이름은 5자 이하여야 합니다.";
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE);
        }
    }
}
