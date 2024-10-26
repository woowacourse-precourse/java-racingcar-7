package racingcar.model;

public class Car {
    String name;
    int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void forward() {
        forwardCount++;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
