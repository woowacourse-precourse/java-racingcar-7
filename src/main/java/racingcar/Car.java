package racingcar;

public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public void move(int distance) {
        location += distance;
    }


    public boolean isAhead(Car other) {
        return this.location > other.location;
    }

    public int getLocation() {
        return location;
    }
}
