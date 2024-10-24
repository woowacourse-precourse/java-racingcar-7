package racingcar;

public class Car {
    private String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
