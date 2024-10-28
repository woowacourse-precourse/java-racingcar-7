package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(START_POSITION);
    }

    public void move() {
        position.forward();
    }

    public Position getPosition() {
        return position;
    }

    public Name getName(){
        return name;
    }
}
