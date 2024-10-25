package racingcar.model;

public class Car {
    private final String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public Car(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void raiseMoveCount() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}

