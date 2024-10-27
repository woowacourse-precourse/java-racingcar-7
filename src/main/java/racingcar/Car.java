package racingcar;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String name) {
        this.carName = name;
    }

    public void chanceToMove() {
        if (MovementCondition.isMovementAllowed().equals("move")) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
