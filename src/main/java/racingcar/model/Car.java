package racingcar.model;


public class Car {
    private final String name;
    private final StringBuilder position;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public void moveIfAboveThreshold(int randomNumber) {
        if (randomNumber >= 4) {
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
