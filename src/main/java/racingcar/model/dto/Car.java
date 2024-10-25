package racingcar.model.dto;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount++;
    }
}
