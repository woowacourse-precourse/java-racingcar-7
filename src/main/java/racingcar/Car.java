package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }
}
