package racingcar.domain;

public class Car {
    private String name;
    private int moveCount;
    private StringBuilder moveString;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
        this.moveString = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getMoveString() {
        return moveString.toString();
    }

    public void move() {
        moveCount++;
        moveString.append("-");
    }
}
