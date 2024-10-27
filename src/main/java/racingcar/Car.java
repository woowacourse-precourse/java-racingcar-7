package racingcar;

public class Car {
    private int location;
    private final String name;

    public Car(String name, int location) {
        this.location = location;
        this.name = name;
    }

    public void move(int distance) {
        location += distance;
    }


    public boolean isAhead(Car other) {
        return this.location > other.location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
