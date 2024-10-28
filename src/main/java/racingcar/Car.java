package racingcar;

public class Car implements Vehicle {
    private String name;
    private int location;

    @Override
    public void move() {

    }

    public void printLocation() {

    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
