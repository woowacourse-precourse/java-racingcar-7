package racingcar.domain;

public class Car {
    private String name;
    private int movementOfNumber = 0;
    private static final int MINIMUM_MOVEMENT_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public void move(int NumberOfMoves) {
        if (NumberOfMoves >= MINIMUM_MOVEMENT_THRESHOLD) {
            movementOfNumber++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMovementOfNumber() {
        return movementOfNumber;
    }
}
