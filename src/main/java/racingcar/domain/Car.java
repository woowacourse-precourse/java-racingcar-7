package racingcar.domain;

public class Car {
    private final CarName name;
    private int movement;

    public Car(String name) {
        this.name = new CarName(name);
        this.movement = 0;
    }

    public void move() {
        movement++;
    }

    public int getMovement() {
        return movement;
    }
}
