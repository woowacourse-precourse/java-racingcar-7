package racingcar.domain;

public class Car {

    private final String name;

    private Integer move = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        checkCarNameLength(name);
        return new Car(name);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        move++;
    }
}
