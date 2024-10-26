package racingcar.dto;

public class Car {
    private final String carName;
    private int moveCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public void move() {
        moveCount += 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
