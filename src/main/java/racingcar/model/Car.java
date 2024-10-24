package racingcar.model;

public class Car {
    private String name;
    private int winningPoint;

    public Car(String name, int winningPoint) {
        this.name = name;
        this.winningPoint = winningPoint;
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
