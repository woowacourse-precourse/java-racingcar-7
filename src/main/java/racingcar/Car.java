package racingcar;

public class Car {
    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        ++moveDistance;
    }

    public int getDistance() {
        return moveDistance;
    }

    public String getName() {
        return name;
    }
}
