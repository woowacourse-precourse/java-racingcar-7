package racingcar.model;

public class Car {
    private String name;
    private int winningPoint;

    public Car(String name) {
        this.name = name;
        this.winningPoint = 0;
    }

    public String getName() {
        return name;
    }

    public int getWinningPoint() {
        return winningPoint;
    }

    public void moveForward() {
        this.winningPoint++;
    }
}
