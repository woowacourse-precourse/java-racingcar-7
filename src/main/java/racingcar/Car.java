package racingcar;

public class Car {
    private final static int INIT_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = INIT_POSITION;
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
