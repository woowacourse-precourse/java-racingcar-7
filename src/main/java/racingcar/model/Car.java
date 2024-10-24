package racingcar.model;

public class Car {

    private final String name;
    private int location;

    private Car(String name) {
        this.name = name;
        location = 0;
    }

    public Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        this.location++;
    }

}
