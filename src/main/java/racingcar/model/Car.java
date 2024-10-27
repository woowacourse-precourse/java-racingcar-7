package racingcar.model;

public class Car {
    private final String name;
    private int location;
    final int MIN_MOVE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
            location++;
        }
    }
}
