package racingcar.model;

public class Location {

    private int location;

    public Location() {
        this.location = 0;
    }

    public void moveForward() {
            location++;
    }

    public int getLocation() {
        return location;
    }
}
