package racingcar;

public class Car {
    private static final int FORWARD_STANDARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= FORWARD_STANDARD) {
            position++;
        }
    }
}
