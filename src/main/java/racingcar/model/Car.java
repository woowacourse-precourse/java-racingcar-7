package racingcar.model;

public class Car {
    private Name name;
    private Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }
}
