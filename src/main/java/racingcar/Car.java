package racingcar;

import static racingcar.ExceptionMessage.*;

public class Car {
    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;

    private static final int POWER_THRESHOLD = 4;
    private static final String POSITION_MARKER = "-";

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = validateCarName(name);
        this.distance = 0;
    }

    public void move(int power) {
        if (power >= POWER_THRESHOLD) {
            this.distance++;
        }
    }

    public String getInfo() {
        return String.format("%s : %s", name, POSITION_MARKER.repeat(distance));
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private static String validateCarName(String name) {
        validateNotNull(name);
        validateNotBlank(name);
        name = name.strip();
        validateNameLength(name);

        return name;
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(INVALID_LENGTH_RANGE_CAR_NAME.getMessage(),
                            MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH, name));
        }
    }

    private static void validateNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }
    }

    private static void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_CAR_NAME.getMessage());
        }
    }
}
