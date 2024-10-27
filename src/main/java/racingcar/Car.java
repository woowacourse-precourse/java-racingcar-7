package racingcar;

public class Car {
    private int location;

    public Car() {
        location = 0;
    }

    public void moveForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
