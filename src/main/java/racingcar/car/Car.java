package racingcar.car;

public class Car {

    private final String name;
    private String forwardNumber;

    public Car(String name) {
        this.name = name;
        forwardNumber = "";
    }

    public String getName() {
        return this.name;
    }

    public String getForwardNumber() {
        return this.forwardNumber;
    }

    public void addForwardNumber() {
        this.forwardNumber += "-";
    }
}
