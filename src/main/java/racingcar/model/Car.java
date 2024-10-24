package racingcar.model;

public class Car {
    private String name;
    private int forwardTime;

    public Car(String name) {
        this.name = name;
    }

    public void forwardCar() {
        this.forwardTime++;
    }

    public String getName() {
        return name;
    }

    public int getForwardTime() {
        return forwardTime;
    }
}
