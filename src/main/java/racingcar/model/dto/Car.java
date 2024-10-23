package racingcar.model.dto;

public class Car {
    private String name;
    private int moveCount;

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    void move(){
        this.moveCount++;
    }
}
