package racingcar;

public class Car {
    private String name;
    private long moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        if (MoveDecision.byRandom()) {
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoveCount() {
        return moveCount;
    }
}
