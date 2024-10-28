package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
    }
}