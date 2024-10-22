package racingcar.model;

public class Car {
    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }
}
