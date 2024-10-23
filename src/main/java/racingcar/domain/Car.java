package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final int position;
    private final String carName;

    public Car(String name) {
        validationEmptyName(name);
        validationNameLength(name);
        this.position = 0;
        this.carName = name;
    }

    private void validationEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validationNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}
