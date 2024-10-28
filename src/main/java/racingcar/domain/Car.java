package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move(int randomValue) {
        if (canMove(randomValue)) {
            position++;
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
