package racingcar.car;

public class Car {

    private final String name;
    private int forward;

    public Car(String name) {
        this.name = name;
        forward = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getForward() {
        return this.forward;
    }

    public void addForward() {
        this.forward += 1;
    }
}
