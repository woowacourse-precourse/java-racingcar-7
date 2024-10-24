package racingcar;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
