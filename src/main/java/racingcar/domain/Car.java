package racingcar.domain;

public class Car {
    private final CarName name;
    private int movement;

    public Car(String name) {
        this(name, 0);
    }

    Car(String name, int movement) {
        this.name = new CarName(name);
        this.movement = movement;
    }

    public void move() {
        movement++;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name.name();
    }
}
