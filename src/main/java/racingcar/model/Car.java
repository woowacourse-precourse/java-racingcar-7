package racingcar.model;

public class Car {
    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5자 이하이어야 합니다.";

    private final String name;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }
}
