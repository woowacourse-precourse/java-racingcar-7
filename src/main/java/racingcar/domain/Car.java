package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public void decideToMove(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            move();
        }
    }
}
