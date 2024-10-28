package racingcar.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location1)) return false;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(location);
    }
}
