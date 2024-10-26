package racingcar.car;

public class Position {
    private static final int DISTANCE = 1;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }

    public void moveForward() {
        position += DISTANCE;
    }
}
