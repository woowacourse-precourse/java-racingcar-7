package racingcar.car;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("Invalid name length");
        }
        this.name = name;
        this.position = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}