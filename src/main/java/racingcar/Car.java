package racingcar;

public class Car {
    private String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    public void move(){
        moveCount++;
    }
}
