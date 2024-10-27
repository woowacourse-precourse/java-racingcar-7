package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveIfPossible(int randomNumber) {
        if (canMove(randomNumber)) {
            moveForward();
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    private void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
