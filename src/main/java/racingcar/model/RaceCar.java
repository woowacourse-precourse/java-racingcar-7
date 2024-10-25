package racingcar.model;

public class RaceCar {
    private static final int INIT_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public RaceCar(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void move() {
        position++;
    }

    public boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }
}
