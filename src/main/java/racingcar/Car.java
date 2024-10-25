package racingcar;

public class Car {
    private String name;
    private String moveCount;

    private CarMoveCondition carMoveCondition;

    public Car(String name, CarMoveCondition carMoveCondition) {
        this.carMoveCondition = carMoveCondition;
        this.name = name;
        this.moveCount = "";
    }

    public String getName() {
        return name;
    }

    public String getMoveCount() {
        return moveCount;
    }

    public void move() {
        if (carMoveCondition.isMovable()) {
            moveCount += "-";
        }
    }
}
