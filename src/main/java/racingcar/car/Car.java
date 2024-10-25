package racingcar.car;

public class Car {

    private final String name;
    private String forward;

    public Car(String name) {
        this.name = name;
        forward = "";
    }

    public String getName() {
        return this.name;
    }

    public String getForward() {
        return this.forward;
    }

    public void addForward() {
        this.forward += "-";
    }
}
