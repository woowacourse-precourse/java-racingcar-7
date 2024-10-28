package racingcar.domain;

public class Car {

    private final String name;
    private String movingDistance;

    public Car(String name) {
        this.name = name;
        this.movingDistance = "";
    }

    public String getName() {
        return name;
    }

    public String getMovingDistance() {
        return movingDistance;
    }

    public void move() {
        this.movingDistance += "-";
    }
}
