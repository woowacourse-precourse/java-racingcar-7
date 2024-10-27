package racingcar.model;

public class Car {

    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name.strip();
        forwardCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public void forward() {
        forwardCount += 1;
    }

}