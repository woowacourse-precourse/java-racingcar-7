package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String HYPHEN = "-";
    private static final String COLON = ":";
    private static final String BLANK = " ";
    private static final int MOVE_THRESHOLD = 4;
    private static final int INIT_DISTANCE_VALUE = 0;

    private final String name;
    private Integer distance;

    public Car(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
        this.name = name;
        this.distance = INIT_DISTANCE_VALUE;
    }

    public String joinCars(List<Car> cars) {
        List<String> list = cars.stream()
                .map(car -> car.name)
                .toList();

        return String.join(", ", list);
    }

    public int compareDistance(Car otherCar) {
        return this.distance.compareTo(otherCar.distance);
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        return this.name + BLANK + COLON + BLANK + createHyphenDistance();
    }

    private String createHyphenDistance() {
        return HYPHEN.repeat(distance);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException();
    }
}
