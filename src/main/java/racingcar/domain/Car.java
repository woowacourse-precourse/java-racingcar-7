package racingcar.domain;

public class Car {

    private final String name;
    private int Location;

    public Car(String name, int Location) {
        this.name = name;
        this.Location = Location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return Location;
    }

    public void move() {
        Location++;
    }
}
