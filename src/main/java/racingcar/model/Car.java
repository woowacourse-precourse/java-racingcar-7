package racingcar.model;

public class Car {
    private String name;
    private int forwardLevel;

    public Car(String name, int forwardLevel) {
        this.name = name;
        this.forwardLevel = forwardLevel;
    }

    public String getName() {
        return name;
    }
    public int getForwardLevel() {
        return forwardLevel;
    }
}
