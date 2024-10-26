package racingcar.domain;

public class Car {
    private String name;
    private static final int CAR_NAME_LENGTH = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
