package racingcar.model;

public class Location {
    private int location;

    private Location(int initLocation) {
        this.location = initLocation;
    }

    public static Location init(int initLocation) {
        return new Location(initLocation);
    }

    public void move() {
        location++;
    }

    public boolean isSame(int winnerLocation) {
        return location == winnerLocation;
    }

    public String makeProgressBar() {
        return "-".repeat(location);
    }

    public int getLocation() {
        return location;
    }
}
