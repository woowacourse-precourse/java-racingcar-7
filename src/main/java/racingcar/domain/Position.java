package racingcar.domain;

public class Position {

    private static final int MOVE_FORWARD_STANDARD = 4;

    private int position;

    public Position() {
        position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_STANDARD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }
}
