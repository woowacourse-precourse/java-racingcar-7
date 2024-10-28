package racingcar.domain;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int forwardCar() {
        return ++position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String positionToString() {
        return "-".repeat(position);
    }
}

