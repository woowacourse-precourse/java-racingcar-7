package racingcar.game.car;

public class Car {
    private static final int  MIN_LOCATION = 0;
    private static final int  MAX_NAME_LENGTH = 5;

    private int location;
    private final String name;

    public Car(String name, int location) {
        if(isOutOfLocationRange(location) || isOutOfMaxLength(name))
            throw new IllegalArgumentException();
        this.location = location;
        this.name = name;

    }

    public void move(int distance) {
        int nextLocation = location + distance;
        if(isOutOfLocationRange(nextLocation))
            throw new IllegalArgumentException();
        location = nextLocation;
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

    private boolean isOutOfLocationRange(int location) {
        return location < MIN_LOCATION;
    }

    private boolean isOutOfMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
