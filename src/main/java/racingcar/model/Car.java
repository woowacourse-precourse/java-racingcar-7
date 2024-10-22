package racingcar.model;

public class Car {
    private final String name;
    private int advanceCount;

    public Car(String name) {
        this.name = name;
        advanceCount = 0;
    }

    public String getName() {
        return name;
    }

    public void advance() {
        advanceCount++;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void stop() { }
}
