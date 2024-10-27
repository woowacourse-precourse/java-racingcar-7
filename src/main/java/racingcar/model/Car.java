package racingcar.model;

public class Car {
    private final String name;
    private final StringBuilder position;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public StringBuilder getPosition() {
        return position;
    }

    public boolean canMove(CarMovement carMovement) {
        return carMovement.isMovable();
    }

    public void move() {
        position.append("-");
    }
}
