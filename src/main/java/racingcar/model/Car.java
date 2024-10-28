package racingcar.model;

public class Car {
    private final String name;
    private int location;
    public Car(String name) {
        this.name = name;
        this.location = 0;
    }
    public void move(int randomValue) {
        if (randomValue >= 4) {
            location++;
        }
    }
    public String getName() {
        return name;
    }
    public int getLocation() {
        return location;
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }
}

