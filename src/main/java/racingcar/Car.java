package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
