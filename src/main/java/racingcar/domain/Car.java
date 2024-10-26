package racingcar.domain;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        location++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
