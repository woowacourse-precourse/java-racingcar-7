package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int location;

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

    public void move() {
        location++;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.location, o.location);
    }
}
