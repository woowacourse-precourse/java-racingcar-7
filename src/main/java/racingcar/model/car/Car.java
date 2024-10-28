package racingcar.model.car;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        forwardCount = 0;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(forwardCount);
    }

    public final void goForward() {
        forwardCount += 1;
    }

    public final int getForwardCount() {
        return forwardCount;
    }

    public final String getName() {
        return name;
    }
}
