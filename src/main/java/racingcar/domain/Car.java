package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
