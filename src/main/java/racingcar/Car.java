package racingcar;

public class Car {
    private String carName;
    private int moveCount;

    public Car(String carName){
        this.carName = carName;
        this.moveCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
