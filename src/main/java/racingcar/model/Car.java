package racingcar.model;

public class Car {
    private final String name;
    private int status = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public void moveCar() {
        status += 1;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
