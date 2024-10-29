package racingcar.model;


public class Car {
    private final String name;
    private final StringBuilder position;
    private final int THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public void moveIfAboveThreshold(int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            position.append('-');
        }
    }

    public String getPosition() {
        return position.toString();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + getPosition();
    }
}
