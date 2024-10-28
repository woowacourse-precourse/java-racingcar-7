package racingcar;

public class Car {
    private final String name;
    private String moveCount = "";

    private final CarMoveCondition carMoveCondition;

    public Car(String name, CarMoveCondition carMoveCondition) {
        this.carMoveCondition = carMoveCondition;
        this.name = name;
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
