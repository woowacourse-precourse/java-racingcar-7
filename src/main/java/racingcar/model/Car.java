package racingcar.model;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVABLE_NUMBER = 4;

    private String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int condition) {
        if (condition >= MOVABLE_NUMBER) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
