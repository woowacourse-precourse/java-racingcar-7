package racingcar;

public class Car {
    private final String name;
    private final int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }
}
